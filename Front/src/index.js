import React from "react";
import ReactDOM from "react-dom";
import {Route, Link, HashRouter as Router, Switch} from "react-router-dom";
import Home from "./componenst/Home";
import NotFound from "./componenst/NotFound";
import { Container, Navbar, Nav, Button, Form } from "react-bootstrap";
import Login from "./componenst/Login/Login";
import Orders from "./componenst/orders/Orders";
import EdditOrder from "./componenst/orders/EdditOrder";

class App extends React.Component {
    render(){
     return (
       <div>
        <Router>
         <Navbar bg = "dark" variant = "dark" expand>
          <Navbar.Brand as = {Link} to = "/">
              Welcome
          </Navbar.Brand> 
           <Nav className="mr-auto">
                <Nav.Link as={Link} to="/orders">
                  Orders
                </Nav.Link>
              </Nav>

              {window.localStorage['jwt'] ? 
                  <Button onClick = {()=>logout()}>Log out</Button> :
                  <Nav.Link as={Link} to="/login">Log in</Nav.Link>
              }
            </Navbar>

            <Container style={{marginTop:25}}>
              <Switch>
                <Route exact path="/" component={Home} />
                <Route exact path="/orders" component={Orders} />
                <Route exact path="/orders/edit/:id" component={EdditOrder} />
                <Route exact path="/login" component={Login}/>
                <Route component={NotFound} />
              </Switch>
            </Container>
          </Router>
        </div>
     );
    }
}

ReactDOM.render (
    <App/>,
    document.querySelector("#root")
);
