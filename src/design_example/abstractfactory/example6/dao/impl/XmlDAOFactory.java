package design_example.abstractfactory.example6.dao.impl;


import design_example.abstractfactory.example6.dao.dao.DAOFactory;

public class XmlDAOFactory implements DAOFactory {
	public OrderDetailDAO createOrderDetailDAO() {
		return new XmlDetailDAOImpl();
	}
	public OrderMainDAO createOrderMainDAO() {
		return new XmlMainDAOImpl();
	}
}