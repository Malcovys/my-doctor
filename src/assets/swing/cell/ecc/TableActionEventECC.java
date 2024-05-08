package assets.swing.cell.ecc;

/**
 *
 * @author RAVEN
 */
public interface TableActionEventECC {

    public void onEdit(int row);
    
    public void onCancel(int row);

    public void onComplete(int row);
}
