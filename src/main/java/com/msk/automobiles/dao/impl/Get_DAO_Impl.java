package com.msk.automobiles.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.msk.automobiles.dao.interfaces.Get_DAO_Interface;
import com.msk.automobiles.service.entities.Car_Brands;
import com.msk.automobiles.service.entities.Car_Models;
import com.msk.automobiles.service.entities.Customer_Contact_Details;
import com.msk.automobiles.service.entities.Customer_Details;
import com.msk.automobiles.service.entities.Location;
import com.msk.automobiles.service.entities.MSK_Owner;
import com.msk.automobiles.service.entities.Notification;
import com.msk.automobiles.service.entities.Parts;
import com.msk.automobiles.service.entities.Service_Adviser;
import com.msk.automobiles.service.entities.Service_Invoice_Card;
import com.msk.automobiles.service.entities.Service_Type;

@Repository
@SuppressWarnings("unchecked")
public class Get_DAO_Impl implements Get_DAO_Interface {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Car_Brands> getAllBrands() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Car_Brands ");
		List<Car_Brands> car_Brands = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return car_Brands;
	}

	@Override
	public List<Car_Models> getModelsByBrandId(Integer car_brands_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Car_Models where car_brands_id = '" + car_brands_id + "'");
		List<Car_Models> car_Models = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return car_Models;
	}

	@Override
	public List<Car_Models> getModelsByBrandIdAndModel(Integer car_brands_id, String model) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(
				" from Car_Models where car_brands_id = '" + car_brands_id + "' and model = '" + model + "'");
		List<Car_Models> car_Models = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return car_Models;
	}

	@Override
	public List<MSK_Owner> getMSKOwnerDetail(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from MSK_Owner where (name = '" + username + "' or email = '" + username
				+ "' or mobile = '" + username + "')");
		List<MSK_Owner> msk_Owners = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return msk_Owners;
	}

	@Override
	public List<Car_Brands> getBrandById(Integer brand_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Car_Brands where id = '" + brand_id + "'");
		List<Car_Brands> car_Brands = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return car_Brands;
	}

	@Override
	public List<Car_Models> getModelById(Integer model_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Car_Models where id = '" + model_id + "'");
		List<Car_Models> car_Models = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return car_Models;
	}

	@Override
	public List<Car_Brands> getByBrand(String brand) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Car_Brands where brand = '" + brand + "'");
		List<Car_Brands> car_Brands = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return car_Brands;
	}

	@Override
	public List<Customer_Details> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Customer_Details ");
		List<Customer_Details> customer_Details = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return customer_Details;
	}

	@Override
	public List<Customer_Contact_Details> getCustomerContactDetails(Integer customer_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery(" from Customer_Contact_Details where customer_details_id = '" + customer_id + "'");
		List<Customer_Contact_Details> contact_Details = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return contact_Details;
	}

	@Override
	public List<Service_Invoice_Card> getSericeInvoiceCard(Integer customer_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery(" from Service_Invoice_Card where customer_details_id = '" + customer_id + "'");
		List<Service_Invoice_Card> service_Invoice_Cards = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return service_Invoice_Cards;
	}

	@Override
	public List<Location> getLocation() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Location ");
		List<Location> location = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return location;
	}

	@Override
	public List<Service_Type> getServiceType() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Service_Type ");
		List<Service_Type> service_Types = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return service_Types;
	}

	@Override
	public List<Service_Invoice_Card> getServiceInvoiceCards() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Service_Invoice_Card ");
		List<Service_Invoice_Card> service_Invoice_Cards = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return service_Invoice_Cards;
	}

	@Override
	public List<Service_Invoice_Card> getServiceInvoiceCardsByStatus(String service_card_status) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery(" from Service_Invoice_Card where card_status = '" + service_card_status + "'");
		List<Service_Invoice_Card> service_Invoice_Cards = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return service_Invoice_Cards;
	}

	@Override
	public String getLocationByCityId(Integer location_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Location where id = '" + location_id + "'");
		List<Location> locations = query.list();
		String city = null;

		if (!locations.isEmpty()) {
			city = locations.get(0).getCity();
		} else {
			city = "empty";
		}

		transaction.commit();
		session.flush();
		session.close();

		return city;
	}

	@Override
	public List<Parts> getSparePartsInStock(String parts_status) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Parts where parts_status = '" + parts_status + "' ");
		List<Parts> parts = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return parts;
	}

	@Override
	public List<Parts> getSparePartsInStockById(String spare_part_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Parts where id = '" + spare_part_id + "' ");
		List<Parts> parts = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return parts;
	}

	@Override
	public List<Parts> getSparePartsAtParticularModel(String model_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery(" from Parts where car_models_id = '" + model_id + "' and parts_status = 'INSTOCK'");
		List<Parts> parts = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return parts;
	}

	@Override
	public List<Parts> getSparePartsAtParticularModelParts(Integer model_id, String part) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery(" from Parts where car_models_id = '" + model_id + "' and part = '" + part + "'");
		List<Parts> parts = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return parts;
	}

	@Override
	public List<Customer_Details> getExistingCustomerModelDetails(Integer car_models_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Customer_Details where car_models_id = '" + car_models_id + "'");
		List<Customer_Details> customer_Details = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return customer_Details;
	}

	@Override
	public List<Service_Adviser> getServiceAdvicers() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Service_Adviser ");
		List<Service_Adviser> service_Advisers = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return service_Advisers;
	}

	@Override
	public List<Notification> getAllNotificationDetails() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Notification where view_status = 0 ");
		List<Notification> notifications = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return notifications;
	}

	@Override
	public List<Customer_Details> getCustomerRegistrationNo(String registration_no) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Customer_Details where registration_no = '" + registration_no + "'");
		List<Customer_Details> customer_Details = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return customer_Details;
	}

	@Override
	public List<Customer_Details> getCustomerDetailByCustomerId(String customer_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Customer_Details where customer_id = '" + customer_id + "'");
		List<Customer_Details> customer_Details = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return customer_Details;
	}

	@Override
	public List<Customer_Details> getCustomerDetailById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Customer_Details where id = '" + id + "'");
		List<Customer_Details> customer_Details = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return customer_Details;
	}

	@Override
	public List<Notification> getNotificationDetailsById(Integer notification_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Notification where id = '" + notification_id + "'");
		List<Notification> notifications = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return notifications;
	}

	@Override
	public List<Service_Type> getServiceTypeById(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Service_Type where id = '" + id + "'");
		List<Service_Type> service_Types = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return service_Types;
	}

	@Override
	public List<Service_Invoice_Card> getSericeInvoiceCardByServiceId(String service_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(" from Service_Invoice_Card where service_id = '" + service_id + "'");
		List<Service_Invoice_Card> service_Invoice_Cards = query.list();
		transaction.commit();
		session.flush();
		session.close();
		return service_Invoice_Cards;
	}

}
