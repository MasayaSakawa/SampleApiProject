<?php
use Fuel\Core\DB;
class Model_Product extends Model {

    /*
     * 全データの取得
     */
    public static function find_all() {
        $query = DB::select ( '*' )->from ( 'product' );
        return $query->execute ();
    }

    /*
     * 特定データの取得
     */
    public static function find($id) {
        $query = DB::select ()->from ( 'product' );
        $query->where ( 'id', $id );
        return $query->execute ();
    }

    /*
     * データの登録
     */
    public static function add($name, $price) {
        $query = DB::insert ( 'product' );
        $query->set ( array (
                'name' => ( string ) $name,
                'price' => ( int ) $price
        ) );
        return $query->execute ();
    }

    /*
     * データの削除
     */
    public static function delete($id) {
        $query = DB::delete ( 'product' );
        $query->where ( 'id', $id );
        return $query->execute ();
    }
}
