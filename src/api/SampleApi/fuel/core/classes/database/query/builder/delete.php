<?php
/**
 * Part of the Fuel framework.
 *
 * @package    Fuel
 * @version    1.8
 * @author     Fuel Development Team
 * @license    MIT License
 * @copyright  2010 - 2016 Fuel Development Team
 * @copyright  2008 - 2009 Kohana Team
 * @link       http://fuelphp.com
 */

namespace Fuel\Core;

class Database_Query_Builder_Delete extends \Database_Query_Builder_Where
{
	// DELETE FROM ...
	protected $_table;

	/**
	 * Set the table for a delete.
	 *
	 * @param mixed $table table name or array($table, $alias) or object
	 */
	public function __construct($table = null)
	{
		if ($table)
		{
			// Set the initial table name
			$this->_table = $table;
		}

		// Start the query with no SQL
		parent::__construct('', \DB::DELETE);
	}

	/**
	 * Sets the table to delete from.
	 *
	 * @param   mixed  $table  table name or array($table, $alias) or object
	 *
	 * @return  $this
	 */
	public function table($table)
	{
		$this->_table = $table;

		return $this;
	}

	/**
	 * Compile the SQL query and return it.
	 *
	 * @param   mixed  $db  Database_Connection instance or instance name
	 *
	 * @return  string
	 */
	public function compile($db = null)
	{
		if ( ! $db instanceof \Database_Connection)
		{
			// Get the database instance
			$db = \Database_Connection::instance($db);
		}

		// Start a deletion query
		$query = 'DELETE FROM '.$db->quote_table($this->_table);

		if ( ! empty($this->_where))
		{
			// Add deletion conditions
			$query .= ' WHERE '.$this->_compile_conditions($db, $this->_where);
		}

		if ( ! empty($this->_order_by))
		{
			// Add sorting
			$query .= ' '.$this->_compile_order_by($db, $this->_order_by);
		}

		if ($this->_limit !== null)
		{
			// Add limiting
			$query .= ' LIMIT '.$this->_limit;
		}

		return $query;
	}

	/**
	 * Reset the query parameters
	 *
	 * @return $this
	 */
	public function reset()
	{
		$this->_table = NULL;

		$this->_where    = array();
		$this->_order_by = array();

		$this->_parameters = array();

		$this->_limit = NULL;

		return $this;
	}
}
