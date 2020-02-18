package start.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import abteilungen.DaoAbteilung;
import abteilungen.business_classes.Abteilung;
import artikel.DaoArtikel;
import general.code.GeschaeftDB;
import general.code.Utils;
import general.design.Colors;
import general.design.Fonts;
import main.dao.DaoGescheaft;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class BesuchAlsGast extends JFrame {
	DaoGescheaft daoGescheaft;
	private JTree tree;
	DaoAbteilung abteilung;
	ArrayList<DefaultMutableTreeNode> defaultMutableTreeNodes;
	private JLabel lblArtikel;
	private JList list_1;
	private JScrollPane scrollPane;
	DaoArtikel artikel;
	private JButton buttonNewButton;
	private JLabel labelNewLabel;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BesuchAlsGast frame = new BesuchAlsGast();
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
	public BesuchAlsGast() {
		daoGescheaft = new DaoGescheaft();
		abteilung = new DaoAbteilung();
		artikel = new DaoArtikel();
		initGUI();
	}

	private void initGUI() {
		Utils.setMainFrameOptions(this);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.decode(Colors.LIGHT_GREY));
		setContentPane(contentPane);
		{
			contentPane.setLayout(null);
			{
				scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 11, 400, 471);
				contentPane.add(scrollPane_1);
				tree = new JTree();
				scrollPane_1.setViewportView(tree);
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
				tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Alle Geschäfte") {
					{
						ArrayList<String> list = daoGescheaft.getAllNames();
						for (String geschaeft : list) {
							System.out.println("Geschäft: " + geschaeft);
							DefaultMutableTreeNode defaultMutableTreeNode = new DefaultMutableTreeNode(geschaeft);
							for (int j = 0; j < abteilung.Abteilungen(geschaeft).length; j++) {
								defaultMutableTreeNode.add(
										new DefaultMutableTreeNode(abteilung.Abteilungen(geschaeft)[j].getNameAbteilung()));
							}
							add(defaultMutableTreeNode);
						}
					}
				}));
			}lblArtikel = new JLabel("");
			lblArtikel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			Fonts.setCenturySchoolbookFont(lblArtikel, 20);
			lblArtikel.setBounds(369, 70, 0, 0);
			contentPane.add(lblArtikel);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(420, 45, 454, 437);
			getContentPane().add(scrollPane);
			{
				list_1 = new JList();
				scrollPane.setViewportView(list_1);

			}
		}
		{
			buttonNewButton = new JButton("Fenster schließen");
			buttonNewButton.setLocation(20, 493);
			buttonNewButton.setSize(854, 23);
			buttonNewButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					openMain();
				}
			});
			Utils.setStandardButtonOptions(buttonNewButton);
			contentPane.add(buttonNewButton);
		}
		{
			labelNewLabel = new JLabel("Artikeln");
			Fonts.setCenturySchoolbookFont(labelNewLabel, 20);
			labelNewLabel.setForeground(Colors.parseColor(Colors.SEXY_BLUE));
			labelNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			labelNewLabel.setBounds(420, 11, 454, 23);
			contentPane.add(labelNewLabel);
		}
	}

	private String getAbteilungFromItem() {

		String nameabteilung = "";
		DefaultMutableTreeNode selectedElement = (DefaultMutableTreeNode) tree.getSelectionPath().getParentPath()
				.getLastPathComponent();

		GeschaeftDB.getInstance().setCurrentAccountName(selectedElement.toString());
		nameabteilung = selectedElement.toString();
		return nameabteilung;
	}

	protected void do_tree_ancestorAdded(AncestorEvent arg0) {
		try {

		} catch (Exception e) {

		}
	}
	
	private void openMain() {
		JFrameStart start = new JFrameStart();
		Utils.reviewOldJFrame(this, start);
	}

	protected void do_tree_valueChanged(TreeSelectionEvent arg0) {
		try {
			String[] values = ARTIKELABHOLEN();
			if(values.length == 0) {
				JOptionPane.showMessageDialog(this, "Die ausgewählte Abteilung enthält keine Produkte zum Anzeigen.");
			}
			list_1.setModel(new AbstractListModel() {
				public int getSize() {
					return values.length;
				}

				public Object getElementAt(int index) {
					return values[index];
				}
			});

		} catch (Exception e) {
		}

	}

	private String[] ARTIKELABHOLEN() {
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
		int selectedIndex = selectedNode.getParent().getIndex(selectedNode);
		System.out.println(selectedIndex);
		System.out.println("GESCHÄFT: " + getAbteilungFromItem());
		Abteilung currentAbteilung = abteilung.Abteilungen(getAbteilungFromItem())[selectedIndex];
		System.out.println("CURRENT ABTEILUNG: " + currentAbteilung.getNameAbteilung() + "\nABTEILUNG ID: " + currentAbteilung.getId());
		
		System.out.println("CURRENT GESCHÄFT FROM INSTANCE: " + GeschaeftDB.getInstance().getCurrentAccountName());
		System.out.println("CURRENT GESCHÄFT : " + getAbteilungFromItem());
		String[] artikell = new String[artikel.loadAbteilungArtikeln(currentAbteilung.getId()).size()];
		System.out.println("ARTIKELS");
		for (int i = 0; i < artikell.length; i++) {
			artikell[i] = artikel.loadAbteilungArtikeln(currentAbteilung.getId()).get(i).getNameArtikel();
		}
		return artikell;
	}
}
