package swing_extensions;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class JRadioButtonList extends JPanel {
	// Radio buttons
	private ArrayList<JRadioButton> radioButtons = null;
	// Button group
	private ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Constructs a JRadioButtonList object with an empty data set.
	 */
	public JRadioButtonList() {
		this(new String[0]);
	}

	/**
	 * Constructs a JRadioButtonList object and sets the data on which it's
	 * built.
	 * @param data A String array containing the text for each JRadioButton
	 */
	public JRadioButtonList(String[] data) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.radioButtons = new ArrayList<JRadioButton>();
		this.setData(data);
	}

	/**
	 * Constructs a JRadioButtonList object, sets the data on which it's built,
	 * and selects the button at the provided index.
	 * @param data A String array containing the text for each JRadioButton
	 * @param selectionIndex Index of the button to select
	 * @throws IndexOutOfBoundsException
	 */
	public JRadioButtonList(String[] data, int selectionIndex) throws IndexOutOfBoundsException {
		this(new String[0]);

		if (selectionIndex >= 0 && selectionIndex < data.length)
			this.select(selectionIndex);
		else throw new IndexOutOfBoundsException();
	}

	/**
	 * Sets the data on which the JRadioButtonList is built.
	 * @param data A String array containing the text for each JRadioButton
	 */
	public void setData(Object[] data) {
		this.radioButtons.clear();
		this.removeAll();

		for (int i = 0; i < data.length; i++) {
			this.radioButtons.add(new JRadioButton(data[i].toString()));
			this.add(this.radioButtons.get(i));
			this.buttonGroup.add(this.radioButtons.get(i));
		}
	}

	/**
	 * Gets the text from each of the JRadioButton.
	 * @return A String array containing the text from each JRadioButton
	 */
	public String[] getData() {
		String[] data = new String[this.radioButtons.size()];

		for (int i = 0; i < data.length; i++)
			data[i] = radioButtons.get(i).getText();

		return data;
	}

	/**
	 * Gets the text from the JRadioButton at the provided index.
	 * @param index Index at which the JRadioButton is located
	 * @return the text from the JRadioButton at the provided index
	 */
	public String getData(int index) {
		return this.radioButtons.get(index).getText();
	}

	/**
	 * Gets the JRadioButton at the provided index.
	 * @param index Index at which the JRadioButton is located
	 * @return the JRadioButton at the provided index
	 */
	public JRadioButton get(int index) {
		return this.radioButtons.get(index);
	}

	/**
	 * Gets the selected value.
	 * @return the selected value
	 */
	public String getSelectedValue() {
		for (int i = 0; i < this.radioButtons.size(); i++)
			if (this.radioButtons.get(i).isSelected())
				return this.radioButtons.get(i).getText();

		return null;
	}

	/**
	 * Gets the selected index.
	 * @return the selected index
	 */
	public int getSelectedIndex() {
		for (int i = 0; i < this.radioButtons.size(); i++)
			if (this.radioButtons.get(i).isSelected())
				return i;

		return -1;
	}

	/**
	 * Selects the JRadioButton at the provided index, and deselects all the
	 * other JRadioButtons.
	 * @param index JRadioButton at the provided index
	 */
	public void select(int index) {
		// Deselect all radio buttons
		this.deselectAll();

		// Select radio button at index
		this.radioButtons.get(index).setSelected(true);
	}

	/**
	 * Deselects all JRadioButtons.
	 */
	public void deselectAll() {
		this.buttonGroup.clearSelection();
	}

	/**
	 * Enables all JRadioButtons.
	 */
	@Override
	public void setEnabled(boolean enabled) {
		for (int i = 0; i < this.radioButtons.size(); i++)
			this.radioButtons.get(i).setEnabled(enabled);
	}

	/**
	 * Gets the number of radio buttons.
	 * @return the number of radio buttons
	 */
	public int length() {
		return this.radioButtons.size();
	}

	/**
	 * {@inheritDoc}
	 */
	public void addActionListener(ActionListener listener) {
		for (int i = 0; i < this.radioButtons.size(); i++)
			this.radioButtons.get(i).addActionListener(listener);
	}
}
