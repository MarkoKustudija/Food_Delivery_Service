import React from "react";
import {Button, Form} from "react-bootstrap";

import FoodDeliveryAxios from "../../apis/FoodDeliveryAxios";

class EditOrder extends React.Component{
    constructor (props){
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
            order:order,
            bills: [],
            deliverers:[]
        };
    }
    componentDidMount(){
        this.getData();
    }
    async getData(){
        await this.getBills();
        await this.getDeliverers();
        await this.getOreders();
    }

    async getOreders(){
        try{
            let result = await FoodDeliveryAxios.get("/orders/" + this.props.match.params.id);
            if(result && result.status === 200){
                this.setState({
                    order: result.data
                });
            }
        }catch (error){
            alert ("Fetching didn't success");
        }
    }

    async getBills(){
        try{
            let result = await FoodDeliveryAxios.get("/bills");
            if(result && result.status === 200){
                this.setState({
                    bills: result.data
                });
            }
        }catch (error){
            alert ("Fetching didn't success");
        }
    }

    async getDeliverers (){
        try{
            let result = await FoodDeliveryAxios.get("/orders");
            if(result && result.status === 200){
                this.setState({
                    deliverers: result.data
                });
            }
        }catch (error){
            alert ("Fetching didn't success");
        }
    }

    async doCreate(){
        try{
            await FoodDeliveryAxios.put("/orders/" + this.props.match.params.id, this.state.order);
            this.props.history.push("/orders");
        }catch(error){
            alert ("Couldn't create");
        }
        }

    valueInputChange(event){
        let control = event.target;

        let name = control.name;
        let value = control.value;

        let order = this.state.order;
        order[name] = value;
        
        this.setState({order: order});
        }
    
    render() {
     return(
         <div>
           <h1> Order </h1>

         <Form>
           <Form.Group>
           <Form.Label> Order number </Form.Label>
           <Form.Control
           onChange = {(event) => this.valueInputChange(event)}
           name = "orderNumber"
           value = {this.state.order.orderNumber}
           as = "input"
           ></Form.Control>
           </Form.Group>
           <Form.Group>
           <Form.Label> Date </Form.Label>
           <Form.Control
           onChange = {(event) => this.valueInputChange(event)}
           name = "date"
           value = {this.state.order.date}
           as = "select"
           ></Form.Control>
           </Form.Group>
           <Form.Group>
           <Form.Label> Delivery address </Form.Label>
           <Form.Control
           onChange = {(event) => this.valueInputChange(event)}
           name = "address"
           value = {this.state.order.address}
           as = "input"
           ></Form.Control>
           </Form.Group>
           <Form.Group>
           <Form.Label> Order price</Form.Label>
           <Form.Control
           onChange = {(event) => this.valueInputChange(event)}
           name = "price"
           value = {this.state.order.price}
           as = "input"
           ></Form.Control>
           </Form.Group>
           <Form.Group>
           <Form.Label> Description</Form.Label>
           <Form.Control
           onChange = {(event) => this.valueInputChange(event)}
           name = "description"
           value = {this.state.order.description}
           as = "input"
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
              <Button variant="primary" onClick={() => this.doCreate()}>
                Create
              </Button>
        </Form>
      </div>
    );
  }
}

export default EditOrder;