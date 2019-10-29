import React from "react";
import { Button, Modal } from "react-bootstrap";
class Example extends React.Component {
  constructor(props) {
    super(props);
    this.state = { show: null };
    this.handleClose = this.handleClose.bind(this);
    this.handleShow = this.handleShow.bind(this);
  }

  handleClose() {
    this.setState({ show: false });
  }
  handleShow() {
    this.setState({ show: true });
  }
  render() {
    return (
      <>
        <Button variant="primary" onClick={this.handleShow}>
          Launch demo modal
        </Button>
        <Modal
          centered
          backdrop="static"
          show={this.state.show}
          onHide={this.handleClose}
          animation={false}
        >
          <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>Woohoo, you're reading this text in a modal!</Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={this.handleClose}>
              Close
            </Button>
            <Button variant="primary" onClick={this.handleClose}>
              Save Changes
            </Button>
          </Modal.Footer>
        </Modal>
      </>
    );
  }
}
export default Example;
