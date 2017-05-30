package control;

public abstract class AbstractDB {
	protected ConnectionDB condb;

	public AbstractDB() {
		this.condb = new ConnectionDB();
	}
}
