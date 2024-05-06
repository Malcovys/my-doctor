package assets.swing.cell;

/**
 *
 * @author RAVEN
 */
public interface TableActionEvent {

    public void onEdit(int row);

    public void onDesable(int row);

    public void onView(int row);
}
