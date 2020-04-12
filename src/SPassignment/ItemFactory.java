
package SPassignment;

import java.util.ArrayList;

public interface ItemFactory {

	public void create();

	public ArrayList<Items> readAll();

	public Items readIndividual(int id);

	public void update(int id);

	public void delete(int id);
}
