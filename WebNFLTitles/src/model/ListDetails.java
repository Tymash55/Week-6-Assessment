package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="list_details")
public class ListDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LIST_ID")
	private int id;
	@Column(name="LIST_NAME")
	private String listName;
	@Column(name="NFL_DATE")
	private LocalDate nflDate;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	

	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
				name="ITEMS_ON_LIST", 
				joinColumns= {@JoinColumn(name="LIST_ID", referencedColumnName="LIST_ID")},
				inverseJoinColumns= {@JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique = true)} 
		)
	private List<ListItem> listOfItems;
	
	public ListDetails() {
		super();
	}
	public ListDetails(int id, String listName, LocalDate nflDate,User user,  List<ListItem> listOfItems) {
		super();
		this.id = id;
		this.listName = listName;
		this.nflDate = nflDate;
		this.listOfItems = listOfItems;
		this.user = user;
	}
	public ListDetails(String listName, LocalDate nflDate,User user, List<ListItem> listOfItems) {
		super();
		this.listName = listName;
		this.nflDate = nflDate;
		this.listOfItems = listOfItems;
		this.user = user;
	}
	
	public ListDetails(String listName, LocalDate nflDate, User user) {
		super();
		this.listName = listName;
		this.nflDate = nflDate;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public LocalDate getNflDate() {
		return nflDate;
	}
	public void setNflDate(LocalDate nflDate) {
		this.nflDate = nflDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<ListItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
}
