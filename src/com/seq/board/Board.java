package com.seq.board;

import java.util.*;
import org.apache.commons.lang3.StringUtils;
import com.seq.cards.*;

public class Board {
	
	public static Set<Square> getOpenSquares() {
		Set<Square> squares = new TreeSet<>();
		for( Card card: Hand.get() )
			squares.addAll( getOpenSquares( card ) );
		return squares;
	}
	
	private static Set<Square> getOpenSquares( Card card ) {
		Set<Square> squares = new TreeSet<>();
		if( !card.getRank().equals( CardRank.CARD_J ) )
			for( int i=1; i<101; i++ )
				if( getSquare(i) != null && StringUtils.isBlank(getSquare(i).getColor()) && getSquare(i).getCard().equals( card ) ) 
					squares.add( getSquare(i) );
		return squares;
	}

	public static void addToken( int positionNumber, String color ) {
		TOKENS.add( new Square( positionNumber, color ) );
	}
	
	public static Square getSquare( int positionNumber ) {
		if( positionNumber < 1 || positionNumber > 100 ) return null;
		for( Square t: TOKENS )
			if( t.getPos() == positionNumber ) return t;
		return new Square( positionNumber, "" );
	}
	
	public static void removeToken( int positionNumber, String color ) {
		TOKENS.add( new Square( positionNumber, color ) );
	}

	public static Card [] [] getCardMatrix() {
		if( CARD_MATRIX == null ) {
			CARD_MATRIX = new Card [100] [100] ;
			CARD_MATRIX [0] [0] = new Card( CardSuit.WILD, CardRank.WILD );
			CARD_MATRIX [0] [1] = new Card( CardSuit.DIAMONDS, CardRank.CARD_6 );
			CARD_MATRIX [0] [2] = new Card( CardSuit.DIAMONDS, CardRank.CARD_7 );
			CARD_MATRIX [0] [3] = new Card( CardSuit.DIAMONDS, CardRank.CARD_8 );
			CARD_MATRIX [0] [4] = new Card( CardSuit.DIAMONDS, CardRank.CARD_9 );
			CARD_MATRIX [0] [5] = new Card( CardSuit.DIAMONDS, CardRank.CARD_T );
			CARD_MATRIX [0] [6] = new Card( CardSuit.DIAMONDS, CardRank.CARD_Q );
			CARD_MATRIX [0] [7] = new Card( CardSuit.DIAMONDS, CardRank.CARD_K );
			CARD_MATRIX [0] [8] = new Card( CardSuit.DIAMONDS, CardRank.CARD_A );
			CARD_MATRIX [0] [9] = new Card( CardSuit.WILD, CardRank.WILD );
			
			CARD_MATRIX [1] [0] = new Card( CardSuit.DIAMONDS, CardRank.CARD_5 );
			CARD_MATRIX [1] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_3 );
			CARD_MATRIX [1] [2] = new Card( CardSuit.HEARTS, CardRank.CARD_2 );
			CARD_MATRIX [1] [3] = new Card( CardSuit.SPADES, CardRank.CARD_2 );
			CARD_MATRIX [1] [4] = new Card( CardSuit.SPADES, CardRank.CARD_3 );
			CARD_MATRIX [1] [5] = new Card( CardSuit.SPADES, CardRank.CARD_4 );
			CARD_MATRIX [1] [6] = new Card( CardSuit.SPADES, CardRank.CARD_5 );
			CARD_MATRIX [1] [7] = new Card( CardSuit.SPADES, CardRank.CARD_6 );
			CARD_MATRIX [1] [8] = new Card( CardSuit.SPADES, CardRank.CARD_7 );
			CARD_MATRIX [1] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_A );
			
			CARD_MATRIX [2] [0] = new Card( CardSuit.DIAMONDS, CardRank.CARD_4 );
			CARD_MATRIX [2] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_4 );
			CARD_MATRIX [2] [2] = new Card( CardSuit.DIAMONDS, CardRank.CARD_K );
			CARD_MATRIX [2] [3] = new Card( CardSuit.DIAMONDS, CardRank.CARD_A );
			CARD_MATRIX [2] [4] = new Card( CardSuit.CLUBS, CardRank.CARD_A );
			CARD_MATRIX [2] [5] = new Card( CardSuit.CLUBS, CardRank.CARD_K );
			CARD_MATRIX [2] [6] = new Card( CardSuit.CLUBS, CardRank.CARD_Q );
			CARD_MATRIX [2] [7] = new Card( CardSuit.CLUBS, CardRank.CARD_T );
			CARD_MATRIX [2] [8] = new Card( CardSuit.SPADES, CardRank.CARD_8 );
			CARD_MATRIX [2] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_K );
			
			CARD_MATRIX [3] [0] = new Card( CardSuit.DIAMONDS, CardRank.CARD_3 );
			CARD_MATRIX [3] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_5 );
			CARD_MATRIX [3] [2] = new Card( CardSuit.DIAMONDS, CardRank.CARD_Q );
			CARD_MATRIX [3] [3] = new Card( CardSuit.HEARTS, CardRank.CARD_Q );
			CARD_MATRIX [3] [4] = new Card( CardSuit.HEARTS, CardRank.CARD_T );
			CARD_MATRIX [3] [5] = new Card( CardSuit.HEARTS, CardRank.CARD_9 );
			CARD_MATRIX [3] [6] = new Card( CardSuit.HEARTS, CardRank.CARD_8 );
			CARD_MATRIX [3] [7] = new Card( CardSuit.CLUBS, CardRank.CARD_9 );
			CARD_MATRIX [3] [8] = new Card( CardSuit.SPADES, CardRank.CARD_9 );
			CARD_MATRIX [3] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_Q );
			
			CARD_MATRIX [4] [0] = new Card( CardSuit.DIAMONDS, CardRank.CARD_2 );
			CARD_MATRIX [4] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_6 );
			CARD_MATRIX [4] [2] = new Card( CardSuit.DIAMONDS, CardRank.CARD_T );
			CARD_MATRIX [4] [3] = new Card( CardSuit.HEARTS, CardRank.CARD_K );
			CARD_MATRIX [4] [4] = new Card( CardSuit.HEARTS, CardRank.CARD_3 );
			CARD_MATRIX [4] [5] = new Card( CardSuit.HEARTS, CardRank.CARD_2 );
			CARD_MATRIX [4] [6] = new Card( CardSuit.HEARTS, CardRank.CARD_7 );
			CARD_MATRIX [4] [7] = new Card( CardSuit.CLUBS, CardRank.CARD_8 );
			CARD_MATRIX [4] [8] = new Card( CardSuit.SPADES, CardRank.CARD_T );
			CARD_MATRIX [4] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_T );
			
			CARD_MATRIX [5] [0] = new Card( CardSuit.SPADES, CardRank.CARD_A );
			CARD_MATRIX [5] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_7 );
			CARD_MATRIX [5] [2] = new Card( CardSuit.DIAMONDS, CardRank.CARD_9 );
			CARD_MATRIX [5] [3] = new Card( CardSuit.HEARTS, CardRank.CARD_A );
			CARD_MATRIX [5] [4] = new Card( CardSuit.HEARTS, CardRank.CARD_4 );
			CARD_MATRIX [5] [5] = new Card( CardSuit.HEARTS, CardRank.CARD_5 );
			CARD_MATRIX [5] [6] = new Card( CardSuit.HEARTS, CardRank.CARD_6 );
			CARD_MATRIX [5] [7] = new Card( CardSuit.CLUBS, CardRank.CARD_7 );
			CARD_MATRIX [5] [8] = new Card( CardSuit.SPADES, CardRank.CARD_Q );
			CARD_MATRIX [5] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_9 );
			
			CARD_MATRIX [6] [0] = new Card( CardSuit.SPADES, CardRank.CARD_K );
			CARD_MATRIX [6] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_8 );
			CARD_MATRIX [6] [2] = new Card( CardSuit.DIAMONDS, CardRank.CARD_8 );
			CARD_MATRIX [6] [3] = new Card( CardSuit.CLUBS, CardRank.CARD_2 );
			CARD_MATRIX [6] [4] = new Card( CardSuit.CLUBS, CardRank.CARD_3 );
			CARD_MATRIX [6] [5] = new Card( CardSuit.CLUBS, CardRank.CARD_4 );
			CARD_MATRIX [6] [6] = new Card( CardSuit.CLUBS, CardRank.CARD_5 );
			CARD_MATRIX [6] [7] = new Card( CardSuit.CLUBS, CardRank.CARD_6 );
			CARD_MATRIX [6] [8] = new Card( CardSuit.SPADES, CardRank.CARD_K );
			CARD_MATRIX [6] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_8 );
			
			CARD_MATRIX [7] [0] = new Card( CardSuit.SPADES, CardRank.CARD_Q );
			CARD_MATRIX [7] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_9 );
			CARD_MATRIX [7] [2] = new Card( CardSuit.DIAMONDS, CardRank.CARD_7 );
			CARD_MATRIX [7] [3] = new Card( CardSuit.DIAMONDS, CardRank.CARD_6 );
			CARD_MATRIX [7] [4] = new Card( CardSuit.DIAMONDS, CardRank.CARD_5 );
			CARD_MATRIX [7] [5] = new Card( CardSuit.DIAMONDS, CardRank.CARD_4 );
			CARD_MATRIX [7] [6] = new Card( CardSuit.DIAMONDS, CardRank.CARD_3 );
			CARD_MATRIX [7] [7] = new Card( CardSuit.DIAMONDS, CardRank.CARD_2 );
			CARD_MATRIX [7] [8] = new Card( CardSuit.SPADES, CardRank.CARD_A );
			CARD_MATRIX [7] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_7 );
			
			CARD_MATRIX [8] [0] = new Card( CardSuit.SPADES, CardRank.CARD_T );
			CARD_MATRIX [8] [1] = new Card( CardSuit.HEARTS, CardRank.CARD_T );
			CARD_MATRIX [8] [2] = new Card( CardSuit.HEARTS, CardRank.CARD_Q );
			CARD_MATRIX [8] [3] = new Card( CardSuit.HEARTS, CardRank.CARD_K );
			CARD_MATRIX [8] [4] = new Card( CardSuit.HEARTS, CardRank.CARD_A );
			CARD_MATRIX [8] [5] = new Card( CardSuit.CLUBS, CardRank.CARD_2 );
			CARD_MATRIX [8] [6] = new Card( CardSuit.CLUBS, CardRank.CARD_3 );
			CARD_MATRIX [8] [7] = new Card( CardSuit.CLUBS, CardRank.CARD_4 );
			CARD_MATRIX [8] [8] = new Card( CardSuit.CLUBS, CardRank.CARD_5 );
			CARD_MATRIX [8] [9] = new Card( CardSuit.CLUBS, CardRank.CARD_6 );
			
			CARD_MATRIX [9] [0] = new Card( CardSuit.WILD, CardRank.WILD );
			CARD_MATRIX [9] [1] = new Card( CardSuit.SPADES, CardRank.CARD_9 );
			CARD_MATRIX [9] [2] = new Card( CardSuit.SPADES, CardRank.CARD_8 );
			CARD_MATRIX [9] [3] = new Card( CardSuit.SPADES, CardRank.CARD_7 );
			CARD_MATRIX [9] [4] = new Card( CardSuit.SPADES, CardRank.CARD_6 );
			CARD_MATRIX [9] [5] = new Card( CardSuit.SPADES, CardRank.CARD_5 );
			CARD_MATRIX [9] [6] = new Card( CardSuit.SPADES, CardRank.CARD_4 );
			CARD_MATRIX [9] [7] = new Card( CardSuit.SPADES, CardRank.CARD_3 );
			CARD_MATRIX [9] [8] = new Card( CardSuit.SPADES, CardRank.CARD_2 );
			CARD_MATRIX [9] [9] = new Card( CardSuit.WILD, CardRank.WILD );
		}
		return CARD_MATRIX;
	}

	private static Card [] [] CARD_MATRIX = null;	
	private static TreeSet<Square> TOKENS = new TreeSet<>();
}