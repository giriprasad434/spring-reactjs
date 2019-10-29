import React from "react";
import {
  Button,
  Navbar,
  Nav,
  NavDropdown,
  FormControl,
  Form
} from "react-bootstrap";
import "./App.css";
import Example from "./components/Example";
import Contact from "./components/Contact";

import { Route, BrowserRouter as Router, Switch } from "react-router-dom";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.fhome = this.fhome.bind(this);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidMount() {
    fetch("http://localhost:1998/bannerdetai")
      .then(res => res.json())
      .then(
        result => {
          this.setState({
            isLoaded: true,
            items: result
          });
        },
        error => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      );
  }

  fhome = fileter => {
    if (fileter.id === 2) {
      console.log(fileter);
      return fileter.title;
    }
  };

  render() {
    if (this.state.error) {
      return <div>Error: {this.state.error.message}</div>;
    } else if (!this.state.isLoaded) {
      return <div>Loading...</div>;
    } else if (this.state.items.length > 0) {
      const name = this.state.items.filter(item => {
        return item.internal === "HOME" || item.internal === "CONTACT";
      });
      const Banner_dropdown = this.state.items.filter(item => {
        return (
          item.internal !== "HOME" &&
          item.internal !== "CONTACT" &&
          item.internal !== "B_DROP_DOWN_TITLE"
        );
      });
      const Banner_title = this.state.items
        .filter(btitle => {
          return btitle.internal === "B_DROP_DOWN_TITLE";
        })
        .map(titl => {
          return titl.display;
        });
      const { error, isLoaded, items } = this.state;
      return (
        <Router>
          <Navbar bg="primary" expand="lg">
            <Navbar.Brand href="/home"> MG </Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="mr-auto">
                {name.map(tit => {
                  return (
                    <Nav.Item key={tit.sno}>
                      <Nav.Link href="/home">{tit.display}</Nav.Link>
                    </Nav.Item>
                  );
                })}

                <NavDropdown title={Banner_title} id="basic-nav-dropdown">
                  {Banner_dropdown.map(dr => {
                    return (
                      <NavDropdown.Item href="/Contact">
                        {dr.display}
                      </NavDropdown.Item>
                    );
                  })}
                </NavDropdown>
              </Nav>
              <Form inline>
                <FormControl
                  type="text"
                  placeholder="Search"
                  className="mr-sm-2"
                />
                <Button variant="outline-dark">Search</Button>
              </Form>
            </Navbar.Collapse>
          </Navbar>
          <Switch>
            <Route path="/home" component={Contact} />
            <Route path="/Contact" component={Example} />
            <Route path="/Example" component={Example} />
          </Switch>
        </Router>
      );
    }else{
      return <div>unable to fetch data from db</div>
    }
  }
}
export default App;
