package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import classes.Timetable;

public class TimetableTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	
	public static final int OBJECT_COL = -1;
	public static final int DAY_COL = 0;
	public static final int HOUR_COL = 1;
	public static final int CLASSNUM_COL = 2;
	public static final int COURSENUM_COL = 3;
	public static final int LECTURERID_COL = 4;
	
	private String[] columnNames = { "Day", "Hour", "Class Number","Course Number", "Lecturer ID"};
	private List<Timetable> timetables;

	public TimetableTableModel(List<Timetable> theTimetables) {
		timetables = theTimetables;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return timetables.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Timetable tempTimetable = timetables.get(rowIndex);

		switch (columnIndex) {
		case COURSENUM_COL:
			return tempTimetable.getCourseNum();
		case LECTURERID_COL:
			return tempTimetable.getLecturerId();
		case CLASSNUM_COL:
			return tempTimetable.getClassNum();
		case DAY_COL:
			return tempTimetable.getDay();
		case HOUR_COL:
			return tempTimetable.getHour()+":00";
		case OBJECT_COL:
			return tempTimetable;
		default:
			return tempTimetable.getCourseNum();
		}
	}
	
	@Override
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}