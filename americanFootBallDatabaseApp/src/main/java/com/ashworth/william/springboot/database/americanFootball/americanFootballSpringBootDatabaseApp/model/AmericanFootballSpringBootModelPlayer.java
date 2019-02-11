package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Data

@Entity
@Table(name = "player")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class AmericanFootballSpringBootModelPlayer implements Serializable
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long playerId;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn
//	@MapsId
//	private AmericanFootballSpringBootModelUser playerusername;
//		
	@NotBlank
	private String preferedRole;
	
	@NotBlank
	private String preferedPosition;
	
	@NotBlank
	private Long userId;
	
	public AmericanFootballSpringBootModelPlayer()
	{
		
	}
		
	public AmericanFootballSpringBootModelPlayer(String preferedRole, String preferedPosition, Long userId)
	{
		this.preferedRole = preferedRole;
		this.preferedPosition = preferedPosition;
		this.userId = userId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPreferedRole() {
		return preferedRole;
	}

	public void setPreferedRole(String preferedRole) {
		this.preferedRole = preferedRole;
	}

	public String getPreferedPosition() {
		return preferedPosition;
	}

	public void setPreferedPosition(String preferedPosition) {
		this.preferedPosition = preferedPosition;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
