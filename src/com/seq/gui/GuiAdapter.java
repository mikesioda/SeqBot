package com.seq.gui;

import java.awt.*;
import javax.swing.*;

import com.seq.*;
import com.seq.board.*;
import com.seq.cards.*;
import com.seq.util.*;


public class GuiAdapter extends JFrame {
	
	public GuiAdapter() {}

	public void init() {
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 500, 410 );
		setLayout( new BorderLayout() );
		setVisible( true );
		guiPanel = PanelBuilder.buildGuiPanel();
		add( guiPanel, BorderLayout.CENTER );
	}
	
	public void refresh() {
		
		if( SeqBot.get().getErrMsg() != null ) GuiAdapter.showError();

		cardRankPicklist.setSelectedIndex( 0 );
		cardSuitPicklist.setSelectedIndex( 0 );
		opponentSuitPicklist.setSelectedIndex( 0 );
		tokenPosition.setText( "" );

		if( SeqBot.get().getMyTokenColor() != null )
			myColorPicklist.setSelectedItem( SeqBot.get().getMyTokenColor() );
		else 
			myColorPicklist.setSelectedIndex( 0 );
		
		if( SeqBot.get().getOpponentTokenColor() != null )
			opponentColorPicklist.setSelectedItem( SeqBot.get().getOpponentTokenColor() );
		else 
			opponentColorPicklist.setSelectedIndex( 0 );
		
		SeqBot.get().setCalcNextMove(false);
		SeqBot.get().setOpponentTokenColor("");
		SeqBot.get().setOpponentJackSuit("");
		SeqBot.get().setOpponentPos(null);
		SeqBot.get().setMyNewCard(null);
		SeqBot.get().setMyNextMove(null);
		SeqBot.get().setErrMsg(null);

		remove( get().getGuiPanel() );
		setGuiPanel( PanelBuilder.buildGuiPanel() );
		add( getGuiPanel(), BorderLayout.CENTER );
		revalidate();
		repaint();
		System.out.println( "SeqBot feels refreshed!" );
	}
	
	public static void showInfo( String msg ) {
		JOptionPane.showMessageDialog( GuiAdapter.get(), msg, "Action Required", JOptionPane.OK_OPTION );
	}
	
	public static void showError() {
		AudioUtil.playAwJeez();
		JOptionPane.showMessageDialog( GuiAdapter.get(), SeqBot.get().getErrMsg(), "Error", JOptionPane.ERROR_MESSAGE );
		SeqBot.get().setErrMsg( null );
	}
	
	public static void showConfirmationWindow( String msg ) throws Exception {
		int n = JOptionPane.showOptionDialog( GuiAdapter.get(), msg + "?", "Confirm Action", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "OK", "Cancel" }, "Cancel" );
		if( n == JOptionPane.NO_OPTION ) throw new Exception( "User cancelled action!" );
	}
	
	public static GuiAdapter get() {
		if( gui == null ) gui = new GuiAdapter();
		return gui;
	}
	
	public JTextField getTokenPosition() {
		return tokenPosition;
	}

	public JComboBox<String> getCardRankPicklist() {
		return cardRankPicklist;
	}

	public JComboBox<String> getCardSuitPicklist() {
		return cardSuitPicklist;
	}

	public JComboBox<String> getOpponentSuitPicklist() {
		return opponentSuitPicklist;
	}
	
	public JComboBox<String> getOpponentColorPicklist() {
		return opponentColorPicklist;
	}

	public JComboBox<String> getMyColorPicklist() {
		return myColorPicklist;
	}

	public JPanel getGuiPanel() {
		return guiPanel;
	}
	
	public void setGuiPanel( JPanel guiPanel ) {
		this.guiPanel = guiPanel;
	}

	static final long serialVersionUID = 8222590183237060065L;
	private static GuiAdapter gui = null;
	private JPanel guiPanel = null;
	private JTextField tokenPosition = new JTextField();
	private JComboBox<String> cardRankPicklist = new JComboBox<String>( CardRank.RANK_NAMES );
	private JComboBox<String> cardSuitPicklist = new JComboBox<String>( CardSuit.SUIT_NAMES );
	private JComboBox<String> opponentSuitPicklist = new JComboBox<String>( CardSuit.SUIT_NAMES );
	private JComboBox<String> opponentColorPicklist = new JComboBox<String>( TokenColor.COLORS );
	private JComboBox<String> myColorPicklist = new JComboBox<String>( TokenColor.COLORS );
}