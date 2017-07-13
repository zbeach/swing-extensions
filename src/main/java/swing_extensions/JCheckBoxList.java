package swing_extensions;

import java.util.ArrayList;

import javax.swing.*;

public class JCheckBoxList extends JPanel {
	// Check boxes
	private ArrayList<JCheckBox> checkBoxes;
	
	/**
	 * Constructs a JCheckBoxList object with an empty data set.
	 */
	public JCheckBoxList() {
		this(new String[0]);
	}
	
	/**
	 * Constructs a JCheckBoxList object and sets the data on which it's built.
	 * @param data A String array containing the text for each JCheckBox
	 */
	public JCheckBoxList(String[] data) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.setData(data);
	}
	
	/**
	 * Sets the data on which the JCheckBoxList is built.
	 * @param data A String array containing the text for each JCheckBox
	 */
	public void setData(String[] data) {
		this.checkBoxes = new ArrayList<JCheckBox>();
	
		for (int i = 0; i < data.length; i++) {
			this.checkBoxes.add(new JCheckBox(data[i]));
			this.add(checkBoxes.get(i));
		}
	}
	
	/**
	 * Gets the text from each of the JCheckBoxes.
	 * @return A String array containing the text from each JCheckBox
	 */
	public String[] getData() {
		String[] data = new String[this.checkBoxes.size()];
		
		for (int i = 0; i < data.length; i++)
			data[i] = checkBoxes.get(i).getText();
		
		return data;
	}
	
	/**
	 * Gets the text from the JCheckBox at the provided index.
	 * @param index Index at which the JCheckBox is located
	 * @return the text from the JCheckBox at the provided index
	 */
	public String getData(int index) {
		return this.checkBoxes.get(index).getText();
	}
	
	/**
	 * Gets the JCheckBox at the provided index.
	 * @param index Index at which the JCheckBox is located
	 * @return the JCheckBox at the procided index
	 */
	public JCheckBox get(int index) {
		return this.checkBoxes.get(index);
	}
	
	/**
	 * Gets an array of the selected values.
	 * @return an array of the selected values
	 */
	public String[] getSelectedValues() {
		ArrayList<String> values = new ArrayList<String>();
		
		for (int i = 0; i < this.checkBoxes.size(); i++) {
			if (this.checkBoxes.get(i).isSelected())
				values.add(this.getData()[i]);
		}
		
		return values.toArray(new String[values.size()]);
	}
	
	/**
	 * Gets an array of the selected indices.
	 * @return an array of the selected indices
	 */
	public int[] getSelectedIndices() {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		for (int i = 0; i < this.checkBoxes.size(); i++) {
			if (this.checkBoxes.get(i).isSelected())
				indices.add(new Integer(i));
		}
		
		int[] pIndices = new int[indices.size()];
		for (int i = 0; i < indices.size(); i++)
			pIndices[i] = indices.get(i).intValue();
		
		return pIndices;
	}

	/**
	 * Selects the JCheckBox at the provided index.
	 * @param index JCheckBox at the provided index
	 */
	public void select(int index) {
		this.checkBoxes.get(index).setSelected(true);
	}
	
	/**
	 * Deselects the JCheckBox at the provided index.
	 * @param index JCheckBox at the provided index
	 */
	public void deselect(int index) {
		this.checkBoxes.get(index).setSelected(false);
	}
	
	/**
	 * Selects all JCheckBoxes in the list.
	 */
	public void selectAll() {
		for (int i = 0; i < this.checkBoxes.size(); i++)
			this.select(i);
	}
	
	/**
	 * Deselects all JCheckBoxes in the list.
	 */
	public void deselectAll() {
		for (int i = 0; i < this.checkBoxes.size(); i++)
			this.deselect(i);
	}
}