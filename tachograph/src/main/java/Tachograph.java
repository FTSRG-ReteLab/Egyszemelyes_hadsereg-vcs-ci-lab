import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class Tachograph {
    private Table<Date, Integer, Integer> table = HashBasedTable.create();


    public void addDataToTable(Date date, Integer position, Integer speed ){
        table.put(date, position, speed);
    }

    public boolean isEmpty(){
        return table.isEmpty();
    }
}
