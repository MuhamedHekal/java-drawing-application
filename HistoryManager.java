import java.awt.List;

public class HistoryManager {
    List actions = new List();

    public void add_action(String action){
        actions.add(action);
    }
    public void undoLast(){
        int lastIndex = actions.getItemCount() - 1;
        actions.remove(lastIndex);
    }
}
