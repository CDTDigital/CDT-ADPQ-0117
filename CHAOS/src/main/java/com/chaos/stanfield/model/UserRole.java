package com.chaos.stanfield.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import com.chaos.stanfield.utils.JPAInitEMF;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@SequenceGenerator(name="UserRoleSeq",initialValue=500)
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="UserRoleSeq")
	@Column(name = "id")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToMany(cascade = { javax.persistence.CascadeType.MERGE,
			javax.persistence.CascadeType.PERSIST }, fetch = FetchType.LAZY, mappedBy = "userRole")
	private Set<UserInfo> userInfos = new HashSet<UserInfo>();

	@Version
	@Column(name = "version")
	private Integer version;

	public String getName() {
		return this.name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public Set<UserInfo> getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", name=" + name + ", description=" + description + ", userInfos=" + userInfos
				+ ", version=" + version + "]";
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addToUserInfos(Iterable<UserInfo> userInfosToAdd) {
		for (UserInfo item : userInfosToAdd) {
			this.userInfos.add(item);
			item.setUserRole(this);
		}
	}

	public void removeFromUserInfos(Iterable<UserInfo> userInfosToRemove) {
		for (UserInfo item : userInfosToRemove) {
			this.userInfos.remove(item);
			item.setUserRole(null);
		}
	}

	public ArrayList<UserRole> allUsersRoles() {
		JPAInitEMF jpa = new JPAInitEMF();
		List<Object> listuserRole = jpa.queryEntities("SELECT r from UserRole r");
		ArrayList<UserRole> userRoleList = new ArrayList<UserRole>();
		for (Object object : listuserRole) {
			userRoleList.add((UserRole) object);
		}
		return userRoleList;
	}


	public UserRole userRoleById(Long id){
		JPAInitEMF jpa=new JPAInitEMF();
		UserRole userRole=new UserRole();
		userRole.setId(id);
		userRole=jpa.getEm().find(UserRole.class,userRole.getId() );
		return userRole;
	}
	
	
}
