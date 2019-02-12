package com.ashworth.william.springboot.database.americanFootball.americanFootballSpringBootDatabaseApp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AmericanFootballSpringBootModelTeamMemberKey implements Serializable
{
	private Long teamid;
	
	private Long playerid;

	public AmericanFootballSpringBootModelTeamMemberKey()
	{
		
	}
	
	public AmericanFootballSpringBootModelTeamMemberKey (Long teamid, Long playerid)
	{
		this.teamid = teamid;
		this.playerid = playerid;
	}
			
	 public Long getTeamid() {
		return teamid;
	}

	public void setTeamid(Long teamid) {
		this.teamid = teamid;
	}

	public Long getPlayerid() {
		return playerid;
	}

	public void setPlayerid(Long playerid) {
		this.playerid = playerid;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
			if (o == null || getClass() != o.getClass())
	            return false;
			AmericanFootballSpringBootModelTeamMemberKey that = (AmericanFootballSpringBootModelTeamMemberKey) o;
	        	return Objects.equals(teamid, that.teamid) &&
	               Objects.equals(playerid, that.playerid);
	}
	 
	@Override
	public int hashCode() 
	{
		return Objects.hash(teamid, playerid);
	}
}
