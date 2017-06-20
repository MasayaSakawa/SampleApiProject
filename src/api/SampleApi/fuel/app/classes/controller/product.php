<?php
class Controller_Product extends Controller_Rest {
    public function action_index() {
        $data = Model_Product::find_all ();
        return $this->response ( $data );
    }
    public function get_add() {
        $name = input::get ( 'name' );
        $price = input::get ( 'price' );
        $ret = Model_Product::add ( $name, $price );
        return $this->response ( $ret );
    }

    public function get_delete() {
        $id = input::get ( 'id' );
        $ret = Model_Product::delete ( $id );
        return $this->response ( $ret );
    }

    public function get_find() {
        $id = input::get ( 'id' );
        $ret = Model_Product::find ( $id );
        return $this->response ( $ret );
    }
}
