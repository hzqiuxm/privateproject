package design_example.abstractfactory.example6.dao.impl;


import design_example.abstractfactory.example6.dao.dao.DAOFactory;

public class RdbDAOFactory implements DAOFactory {
	public OrderDetailDAO createOrderDetailDAO() {
		return new RdbDetailDAOImpl();
	}
	public OrderMainDAO createOrderMainDAO() {
		return new RdbMainDAOImpl();
	}
}
