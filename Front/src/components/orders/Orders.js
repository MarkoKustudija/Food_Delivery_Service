import React from "react";
import { Table, Button, Form, ButtonGroup, Collapse } from "react-bootstrap";

import FoodDeliveryAxios from "../../apis/FoodDeliveryAxios"

class Orders extends React.Component{
    constructor(props){
        super(props);

        let order = {
            orderNumber: 0,
            date: "",
            address:"",
            price:0,
            description:"",
            delivererId: -1,
        };

        this.state = {
            order: order,
            orders:[],
            bills:[],
            deliverers:[],
            showSearch: false,
            search: {address:"", delivererId:-1},
            pageNo: 0,
            totalPages: 1,
            billSum: ""
        };
    }

    componentDidMount(){
        this.getData();
    }

    async getData(){
        await this.getDeliverers();
        await this.getOrders(0);
    }

    async getOrders(page){
        let config = {params: {
            pageNo: page
        } };

        if(this.state.search.address != ""){
            config.params.address = this.state.search.address;
        }
        if(this.state.search.delivererId != -1){
            config.params.delivererId = this.state.search.delivererId;
        }

        try{
            let result = await FoodDeliveryAxios.get("/orders", config);
              if(result && result.status === 200){
                  const billSum = result.headers ["sprint-total"]?result.headers["sprint-total"]:"";
                  this.setState({
                      pageNo: page,
                      orders: result.data,
                      totalPages: result.headers["total-pages"],
                      billSum: billSum
                  });
              }
        }catch (error){
            alert ("Fetching didn't success");
        }
    }
    async getDeliverers(){
        try{
            let result = await FoodDeliveryAxios.get("/deliveres");
            if(result && result.status === 200){
                this.setState({
                    deliverers: result.data,
                });
            }
        }catch(error){
            alert ("Fetching didn't success");
        }
    }
    goToEdit(orderId){
        this.props.history.push("/orders/edit/" + orderId);
    }

    async doAdd(){
        try{
            await FoodDeliveryAxios.post("/orders/", this.state.order);

            let order = {
                orderNumber: 0,
                date: "",
                address:"",
                price:0,
                description:"",
                delivererId: -1,
            };
            this.setState({order:order});

            this.getOrders(0);
        } catch (error){
            alert ("Fetching didn't success");
        }
    }
    async doDelete(orderId){
        try{
            await FoodDeliveryAxios.delete("/orders/" + orderId);
            var nextPage
            if(this.state.pageNo == this.state.totalPages-1 && this.state.orders.length ==1){
                nextPage = this.state.pageNo-1
            } else{
                nextPage = this.state.pageNo
            }
            await this.getOrders(nextPage);
        }catch (error){
            alert ("Couldn't delete order");
        }
    }
    addValueInputChange(event){
        let control = event.tagret;

        let name = control.name;
        let value = control.value;

        let order = this.state.order;
        order[name] = value;

        this.setState({order:order});
    }

    searchValueInputChange(event){
        let control = event.target;

        let name = control.name;
        let value = control.value;

        let search = this.state.search;
        search[name] = value;

        this.setState({search:search})
    }

    doSearch(){
        this.getOrders(0);
    }

    canCreateOrder(){
        const order = this.state.order
        return order.address != "" &&
               order.delivererId != -1
    }

    async changeBill(orderId){
        try{
            const ret = await FoodDeliveryAxios.post(`/orders/${orderId}/change_order`);
            var orders = this.state.orders;
            orders.forEach((element, index)=> {
                if(element.id === orderId){
                    orders.splice(index,1,ret.data);
                    this.setState({orders:orders});
                }
            });
        } catch (error){
            alert ("Order can not be changed");
        }
    }

    render(){
     return(
         <div>
             <h1>Orders</h1>
             {window.localStorage['role']=="ROLE_ADMIN"?
             <Form>
                 <Form.Group>
                     <Form.Label> Order number </Form.Label>
                     <Form.Control
                     onChange = {(event) => this.addValueInputChange(event)}
                     name = "odredNumber"
                     value = {this.state.order.orderNumber}
                     as="input"
                     ></Form.Control>
                </Form.Group>
                <Form.Group>
                     <Form.Label> Date </Form.Label>
                     <Form.Control
                     onChange = {(event) => this.addValueInputChange(event)}
                     name = "date"
                     value = {this.state.order.date}
                     as="select"
                     ></Form.Control>
                </Form.Group>
                <Form.Group>
                     <Form.Label> Address </Form.Label>
                     <Form.Control
                     onChange = {(event) => this.addValueInputChange(event)}
                     name = "address"
                     value = {this.state.order.address}
                     as="input"
                     ></Form.Control>
                </Form.Group>
                <Form.Group>
                     <Form.Label> Order price </Form.Label>
                     <Form.Control
                     onChange = {(event) => this.addValueInputChange(event)}
                     name = "price"
                     value = {this.state.order.price}
                     as="input"
                     ></Form.Control>
                </Form.Group>
                <Form.Group>
                     <Form.Label> Description </Form.Label>
                     <Form.Control
                     onChange = {(event) => this.addValueInputChange(event)}
                     name = "description"
                     value = {this.state.order.description}
                     as="input"
                     ></Form.Control>
                </Form.Group>
                <Form.Group>
                 <Form.Label>Deliverer</Form.Label>
                  <Form.Control
                   onChange={(event) => this.valueInputChange(event)}
                   name="delivererId"
                   value={this.state.order.delivererId}
                   as="select"
                   >
                  <option value={-1}></option>
                   {this.state.deliverers.map((deliverer) => {
                    return (
                    <option value={deliverer.id} key={deliverer.id}>
                    {deliverer.name}
                    </option>
                );
              })}
              </Form.Control>
             </Form.Group>
             <Button disabled = {!this.canCreateOrder()} variant="primary" onClick={() => this.doAdd()}>
               Add
             </Button>
             </Form>:null}

         <Form.Group style = {{marginTop:35}}>
             <Form.Check type = "checkbox" label = "Show search form" onClick = {(event) => this.setState({showSearch: event.target.checked})}/>
         </Form.Group>
         <Collapse in = {this.state.showSearch}>
         <Form style={{marginTop:10}}>
         <Form.Group>
             <Form.Label> Address</Form.Label>
             <Form.Control
             value = {this.state.search.address}
             name="address"
             as="input"
             onChange={(e) => this.searchValueInputChange(e)}
             ></Form.Control>
            </Form.Group>
          <Form.Group>
              <Form.Label> Delliverer</Form.Label>
              <Form.Control
              onChange={(event)=> this.searchValueInputChange(event)}
              name="deliverer"
              value={this.state.search.delivererId}
              as="select"
              >
              <option value={-1}></option>
              {this.state.deliverers.map((deliverer)=>{
                  return(
                      <option value={deliverer.id} key = {deliverer.id}>
                        {deliverer.name}
                        </option>
                  );
              })} 
              </Form.Control>
            </Form.Group>
            <Button onClick={()=> this.doSearch()}>Search</Button>
            </Form>
            </Collapse>

            <ButtonGroup style ={{marginTop:25, float:"right"}}>
               <Button
               style={{margin: 3, width: 90}}
               disabled = {this.state.pageNo ==0} onClick ={()=> this.getOrders(this.state.pageNo-1)}>
                Previous
                </Button>
                <Button
                style ={{margin: 3, width:90}}
                disabled ={this.state.pageNo==this.state.totalPages-1} onClick={()=> this.getOrders(this.state.pageNo+1)}>
                Next
                </Button>
             </ButtonGroup>

             <Table bordered striped style={{marginTop: 5}}>
               <thead className="thead-dark">
               <tr>
                   <th>Order number </th>
                   <th>Date</th>
                   <th>Address</th>
                   <th>Price</th>
                   <th>Description</th>
                   <th>Deliverer</th>
                   <th colSpan ={2}>Actions</th>
                </tr>
                </thead>
                <tbody>
                    {this.state.orders.map((order)=> {
                        return (
                        <tr key = {order.id}>
                          <td>{order.orderNumber}</td>
                          <td>{order.date}</td>
                          <td>{order.address}</td>
                          <td>{order.price}</td>
                          <td>{order.description}</td>
                          <td>{order.delivererId}</td>
                        <td>
                            <Button
                            disabled={order.billId === 3}
                            variant = "info"
                            onClick ={()=> this.changeBill(order.id)}
                            > 
                            Create 
                            </Button>  
                            {window.localStorage['role']== "ROLE_ADMIN"?
                            [<Button
                              variant = "warning"
                              onClick ={() => this.goToEdit(order.id)}
                              style={{marginLeft:5}}
                              >
                              See 
                              </Button>,
                              <Button
                               variant="danger"
                               onClick={() => this.doDelete(order.id)}
                               style={{ marginLeft: 5 }}
                               >
                                Delete 
                              </Button>]:null}
                         </td>
                       </tr>
                        );
                    })}   
                </tbody>
            </Table>
            <h2 hidden ={this.state.billSum ==""}> Sum of all bills {this.state.billSum}</h2>
            </div>

     );
    }

}

export default Orders;
      