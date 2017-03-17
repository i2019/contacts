package tao.book.sia.contacts.repository;


import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tao.book.sia.contacts.model.Contact;
/**
 * 
 * @author 江涛
	为ContactRepository使用了@Repository注解，因此在组件扫
	描的时候，它会被发现并创建为Spring应用上下文中的bean。
	
	当Spring Boot探测到Spring的JDBC模块和H2在类路径下的时候，自动配置就会发挥作用，将会
	自动配置JdbcTemplatebean和H2DataSourcebean。Spring Boot再一次为我们处理了所有的Spring配置。
 */
@Repository
public class ContactRepository {

  private JdbcTemplate jdbc;
  
  @Autowired
  public ContactRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  public List<Contact> findAll() {
    return jdbc.query(
        "select id, firstName, lastName, phoneNumber, emailAddress " +
        "from contacts order by lastName",
        new RowMapper<Contact>() {
          public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
            Contact contact = new Contact();
            contact.setId(rs.getLong(1));
            contact.setFirstName(rs.getString(2));
            contact.setLastName(rs.getString(3));
            contact.setPhoneNumber(rs.getString(4));
            contact.setEmailAddress(rs.getString(5));
            return contact;
          }
        }
      );
  }

  public void save(Contact contact) {
    jdbc.update(
        "insert into contacts " +
        "(firstName, lastName, phoneNumber, emailAddress) " +
        "values (?, ?, ?, ?)",
        contact.getFirstName(), contact.getLastName(),
        contact.getPhoneNumber(), contact.getEmailAddress());
  }
  
}
