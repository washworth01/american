package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "player_team")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "lastModified"}, allowGetters = true)
public class ModelTeamMember implements Serializable
{
	@EmbeddedId
	private AmericanFootballSpringBootModelTeamMemberKey id;
	
	@NotBlank
	@Column
	private int playerNumber;
	
	public ModelTeamMember()
	{
		
	}
	
	public ModelTeamMember(AmericanFootballSpringBootModelTeamMemberKey id)
	{
		this.id = id;
	}
	
	public ModelTeamMember(AmericanFootballSpringBootModelTeamMemberKey id, int playerNumber)
	{
		this.id = id;
		this.playerNumber = playerNumber;
	}

	public AmericanFootballSpringBootModelTeamMemberKey getId() {
		return id;
	}

	public void setId(AmericanFootballSpringBootModelTeamMemberKey id) {
		this.id = id;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
//	@Override
//    public boolean equals(Object o) 
//	{
//        if (this == o) return true;
// 
//        if (o == null || getClass() != o.getClass())
//            return false;
// 
//        ModelTeamMember that = (ModelTeamMember) o;
//        return Objects.equals(team, that.team) &&
//               Objects.equals(player, that.player);
//    }
// 
//    @Override
//    public int hashCode() {
//        return Objects.hash(team, player);
//    }	
}