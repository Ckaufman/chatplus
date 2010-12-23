package ch.hszt.mdp.chatplus.gui;

import java.awt.Insets;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import ch.hszt.mdp.chatplus.logic.concrete.SimpleMessage;
import ch.hszt.mdp.chatplus.logic.concrete.TcpServerPeer;
import ch.hszt.mdp.chatplus.logic.contract.context.IClientContext;

/**
 * 
 * @author pascalbeyeler
 */
public class ChatWindow extends JFrame implements IClientContext {
	
	private static final long serialVersionUID = -1671373001474835583L;
	private JMenuItem connectItem;
	private JMenuItem disconnectItem;
	private JMenuItem exitItem;
	private JMenu fileMenu;
	private JPopupMenu jPopupMenu1;
	private JMenuBar menubar;
	private JTextArea messageDisplay;
	private JScrollPane messageDisplayScroll;
	private JTextArea messageWriting;
	private JLabel messageWritingLabel;
	private JScrollPane messageWritingScroll;
	private JButton sendButton;
	private JList userList;
	private JScrollPane userListScroll;
	private TcpServerPeer serverPeer;
	private String serverIP;
	private Integer serverPort;
	private String username;

	/** Creates new form ChatWindow */
	public ChatWindow() {
		initComponents();
	}

	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	private void initComponents() {

		jPopupMenu1 = new JPopupMenu();
		messageDisplayScroll = new JScrollPane();
		messageDisplay = new JTextArea();
		messageDisplay.setMargin(new Insets(10, 10, 10, 10));
		messageWritingScroll = new JScrollPane();
		messageWriting = new JTextArea();
		messageWriting.setMargin(new Insets(10, 10, 10, 10));
		messageWritingLabel = new JLabel();
		userListScroll = new JScrollPane();
		userList = new JList();
		sendButton = new JButton();
		menubar = new JMenuBar();
		fileMenu = new JMenu();
		connectItem = new JMenuItem();
		disconnectItem = new JMenuItem();
		exitItem = new JMenuItem();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(670, 570);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("ChatPlus");

		messageDisplay.setColumns(20);
		messageDisplay.setRows(5);
		messageDisplay.setEnabled(false);
		messageDisplay.setEditable(false);
		messageDisplay.setLineWrap(true);
		messageDisplayScroll.setViewportView(messageDisplay);
		messageDisplayScroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		messageDisplayScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		messageWriting.setColumns(20);
		messageWriting.setRows(5);
		messageWriting.setLineWrap(true);
		messageWriting.setEnabled(false);
		messageWritingScroll.setViewportView(messageWriting);
		messageWritingScroll
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		messageWritingScroll
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		messageWritingLabel.setText("Enter your message here");

		userList.setToolTipText("Available users");
		userList.setEnabled(false);
		userListScroll.setViewportView(userList);

		sendButton.setText("Send");
		sendButton.setEnabled(false);
		sendButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				sendButtonActionPerformed(evt);
			}
		});

		fileMenu.setText("File");

		connectItem.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_C,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		connectItem.setText("Connect to server");
		connectItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				connectItemActionPerformed(evt);
			}
		});
		fileMenu.add(connectItem);

		disconnectItem.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_D,
				java.awt.event.InputEvent.SHIFT_MASK
						| java.awt.event.InputEvent.CTRL_MASK));
		disconnectItem.setText("Disconnect");
		disconnectItem.setEnabled(false);
		disconnectItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				disconnectItemActionPerformed(evt);
			}
		});
		fileMenu.add(disconnectItem);

		exitItem.setText("Exit");
		exitItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitItemActionPerformed(evt);
			}
		});
		fileMenu.add(exitItem);

		menubar.add(fileMenu);

		setJMenuBar(menubar);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				messageDisplayScroll,
																				GroupLayout.PREFERRED_SIZE,
																				455,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED))
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				messageWritingLabel)
																		.addGap(
																				257,
																				257,
																				257))
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																layout
																		.createSequentialGroup()
																		.addGroup(
																				layout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								sendButton)
																						.addComponent(
																								messageWritingScroll,
																								GroupLayout.DEFAULT_SIZE,
																								455,
																								Short.MAX_VALUE))
																		.addGap(
																				12,
																				12,
																				12)))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(userListScroll,
												GroupLayout.DEFAULT_SIZE, 179,
												Short.MAX_VALUE)
										.addContainerGap()));
		layout
				.setVerticalGroup(layout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												layout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																userListScroll,
																GroupLayout.DEFAULT_SIZE,
																517,
																Short.MAX_VALUE)
														.addGroup(
																layout
																		.createSequentialGroup()
																		.addComponent(
																				messageDisplayScroll,
																				GroupLayout.PREFERRED_SIZE,
																				315,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				messageWritingLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				messageWritingScroll,
																				GroupLayout.PREFERRED_SIZE,
																				123,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				9,
																				Short.MAX_VALUE)
																		.addComponent(
																				sendButton)))
										.addContainerGap()));

		pack();
	}// </editor-fold>

	private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {
		sendMessage(username, messageWriting.getText());
	}

	private void connectItemActionPerformed(java.awt.event.ActionEvent evt) {
		displayConnectionDialog();
	}

	private void disconnectItemActionPerformed(java.awt.event.ActionEvent evt) {
		disconnectFromServer();
	}

	private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ChatWindow mainWindow = new ChatWindow();
				mainWindow.setVisible(true);
				mainWindow.displayConnectionDialog();
			}
		});
	}

	/**
	 * Disable elements
	 * 
	 * Disables all interface elements
	 * 
	 * @return void
	 */

	private final void disableElements() {
		connectItem.setEnabled(true);
		disconnectItem.setEnabled(false);
		messageDisplay.setEnabled(false);
		messageWriting.setEnabled(false);
		sendButton.setEnabled(false);
		userList.setEnabled(false);
	}

	/**
	 * Enable elements
	 * 
	 * Enables all interface elements
	 * 
	 * @return void
	 */

	private final void enableElements() {
		connectItem.setEnabled(false);
		disconnectItem.setEnabled(true);
		messageDisplay.setEnabled(true);
		messageWriting.setEnabled(true);
		sendButton.setEnabled(true);
		userList.setEnabled(true);
	}

	/**
	 * Display connection dialog
	 * 
	 * Open the connection dialog
	 * 
	 * @return void
	 */

	public void displayConnectionDialog() {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				final ConnectionDialog dialog = new ConnectionDialog(
						new JFrame(), true);

				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					public void windowClosed(WindowEvent e) {

						// retreive all the user input from the connection
						// dialog
						username = dialog.getUsername();
						serverIP = dialog.getServerIP();
						serverPort = dialog.getServerPort();

						// connect to the server
						if (connectToServer(serverIP, serverPort)) {
							enableElements();
						} else {
							System.out.println("not connected");
						}

					}

				});
				dialog.setVisible(true);
			}
		});

	}

	/**
	 * Connect to the server
	 * 
	 * Establish the connection between the client and the server
	 * 
	 * @param ip
	 * @param port
	 * @return void
	 */

	private boolean connectToServer(String ip, Integer port) {

		// init the server peer
		serverPeer = new TcpServerPeer();
		serverPeer.setServerIP(ip);
		serverPeer.setServerPort(port);
		serverPeer.setContext(this);

		try {
			// init the server peer. will throw various exceptions if the
			// connection failed
			serverPeer.Init();
			serverPeer.Start();

			// store the server ip and port for later usage
			serverIP = ip;
			serverPort = port;

			return true;
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(this, "Unknown host");
			return false;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,
					"Could not connect to the server");
			return false;
		}

	}

	/**
	 * Disconnect from the server
	 * 
	 * Close the connection to the server
	 * 
	 * @return void
	 */

	private void disconnectFromServer() {
		serverPeer.Stop();
		messageWriting.setText("");
		messageDisplay.setText("");
		disableElements();
	}

	/**
	 * Send message
	 * 
	 * Send a message to the server
	 * 
	 * @param sender
	 * @param message
	 * @return void
	 */

	private final void sendMessage(String sender, String message) {
		// add the message to the queue
		SimpleMessage msg = new SimpleMessage();
		msg.setMessage(message);
		msg.setSender(sender);
		serverPeer.send(msg);

		messageWriting.setText("");
	}

	/**
	 * Display chat message
	 * 
	 * Display a message which was sent by the server
	 * 
	 * @return void
	 */

	@Override
	public void displayChatMessage(String sender, String message) {
		messageDisplay.append(sender + " says:\t" + message + "\n");
	}

}
