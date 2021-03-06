package com.seq.board;

import org.apache.commons.lang3.StringUtils;
import com.seq.*;
import com.seq.cards.*;

public class Square implements Comparable<Square> {

	public Square( int pos, String color ) {
		this.pos = pos;
		this.color = color == null ? "" : color;
	}

	public boolean isWild() {
		return Board.getSquare( pos ).getCard().equals( new Card(CardSuit.WILD, CardRank.WILD) );
	}
	
	public Card getCard() {
		return Board.getCardMatrix()[getRow()][getCol()];
	}
	
	public boolean isOpponents() {
		return StringUtils.isNotBlank( color ) && color.equals( SeqBot.get().getOpponentTokenColor() );
	}
	
	public boolean isMine() {
		return StringUtils.isNotBlank( color ) && color.equals( SeqBot.get().getMyTokenColor() );
	}
	
	public Integer getPos() {
		return pos;
	}

	public String getColor() {
		return color;
	}
	
	public void setColor( String color ) {
		this.color = color;
	}
	
	public int getRow() {
		return ( pos - 1 ) / 10;
	}
	
	public int getCol() {
		return ( pos - 1 ) % 10;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( pos == null ) ? 0: pos.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if( this == obj ) return true;
		if( !( obj instanceof Square ) ) return false;
		Square other = (Square) obj;
		if( pos == null ) {
			if( other.pos != null ) return false;
		} else if( !pos.equals( other.pos ) ) return false;
		return true;
	}

	@Override
	public int compareTo( Square o ) {
		return  pos.compareTo(o.getPos());
	}
	
	@Override
	public String toString() {
		return getCard() + "@" + pos + (StringUtils.isNotBlank(color) ? "=" + color : "");
	}

	private Integer pos;
	private String color;
}
