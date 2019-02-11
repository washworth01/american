//package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
//
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//@Entity
//@Table(name = "team_member")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
//public class ModelTeamMember implements Serializable
//{
//	
//	@Id
//	private Long teamId;
////	@ManyToOne
////	private AmericanFootballSpringBootModelTeamDetail team;
//	
//	@Id
//	private Long playerId;
//	
////	@ManyToOne
////	private AmericanFootballSpringBootModelPlayer player;
////	
//	@NotBlank
//	@Column
//	private int playerNumber;
//	
//	public ModelTeamMember()
//	{
//		
//	}
//	
//	public ModelTeamMember(Long teamId ,Long playerId, int playerNumber)
//	{
//		this.teamId = teamId;
//		this.playerId = playerId;
//		this.playerNumber = playerNumber;
//	}
//
//	public Long getTeamId() {
//		return teamId;
//	}
//
//	public void setTeamId(Long teamId) {
//		this.teamId = teamId;
//	}
//
//	public Long getPlayerId() {
//		return playerId;
//	}
//
//	public void setPlayerId(Long playerId) {
//		this.playerId = playerId;
//	}
//
//	public int getPlayerNumber() {
//		return playerNumber;
//	}
//
//	public void setPlayerNumber(int playerNumber) {
//		this.playerNumber = playerNumber;
//	}
//	
//}