package start.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import main.dao.DaoGescheaft;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import abteilungen.DaoAbteilung;
import artikel.DaoArtikel;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.image.AreaAveragingScaleFilter;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;

public class BesuchalsGast extends JFrame {
	DaoGescheaft daoGescheaft;
	private JTree tree;
	DaoAbteilung abteilung;
	ArrayList<DefaultMutableTreeNode> defaultMutableTreeNodes;
	private JLabel lblArtikel;
	private JList list_1;
	private JScrollPane scrollPane;
	DaoArtikel artikel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BesuchalsGast frame = new BesuchalsGast();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BesuchalsGast() {
		daoGescheaft = new DaoGescheaft();
		abteilung = new DaoAbteilung();
		artikel =new DaoArtikel();
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Utils.setMainFrameOptions(this);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.decode(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			tree = new JTree();
			tree.addTreeSelectionListener(new TreeSelectionListener() {
				public void valueChanged(TreeSelectionEvent arg0) {
					do_tree_valueChanged(arg0);
				}
			});
			tree.addAncestorListener(new AncestorListener() {
				public void ancestorAdded(AncestorEvent arg0) {
					do_tree_ancestorAdded(arg0);
				}
				public void ancestorMoved(AncestorEvent arg0) {
				}
				public void ancestorRemoved(AncestorEvent arg0) {
				}
			});
			tree.setBackground(Colors.parseColor(Colors.LIGHT_PINK));
			tree.setModel(new DefaultTreeModel(
				new DefaultMutableTreeNode("Alle Geschäfte") {
					{
						ArrayList<String> list = daoGescheaft.getAllNames();
						for (String geschaeft : list) {
							int i=0;
							DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(geschaeft);
							if(!abteilung.Abteilungen(geschaeft)[i].equals("")) {
								for (int j = 0; j <abteilung.Abteilungen(geschaeft).length; j++) {
									defaultMutableTreeNode.add(new DefaultMutableTreeNode(abteilung.Abteilungen(geschaeft)[j]));
								}
								
							}
							
							add(defaultMutableTreeNode);
						}
						
					}
				}
			));
			tree.setBounds(10, 11, 260, 406);
			contentPane.add(tree);
			
		}
		{
			lblArtikel = new JLabel("Artikel");
			lblArtikel.setForeground(Color.RED);
			lblArtikel.setFont(new Font("Segoe Script", Font.PLAIN, 21));
			lblArtikel.setBounds(519, 56, 136, 26);
			contentPane.add(lblArtikel);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(434, 81, 260, 260);
			contentPane.add(scrollPane);
			{
				list_1 = new JList();
				scrollPane.setViewportView(list_1);
				
					
				
			
				
				
			}
		}
	}
	private String  dieselecteditem() {
		String  nameabteilung ="";
		DefaultMutableTreeNode selectedElement 
		   =(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
		nameabteilung=selectedElement.toString();
		return nameabteilung;
		}
		
	
	protected void do_tree_ancestorAdded(AncestorEvent arg0) {
		System.out.println("do_tree_ancestorAdded");
		//System.out.println(arrraylisttoArray());
	}
	protected void do_tree_valueChanged(TreeSelectionEvent arg0) {
		System.out.println("do_tree_valueChanged");
		String[] values=ARTIKELABHOLEN(); 
		
		list_1.setModel(new AbstractListModel() {
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	
	}
	private String [] ARTIKELABHOLEN() {
		System.out.println("dsa");
		String [] artikell=new  String[artikel.artikelLaden(dieselecteditem()).size()];
		System.out.println("dsadsa");
		for (int i = 0; i < artikell.length; i++) {
			System.out.println("dsadsaaaaaaaaaaaa");
			artikell[i]=artikel.artikelLaden(dieselecteditem()).get(i).getNameArtikel();
			System.out.println("ARTIKEL: "+artikell[i]);
		}
		return artikell;
		
	}
}
