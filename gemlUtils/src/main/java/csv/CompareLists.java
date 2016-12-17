package csv;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CompareLists<T> {

    String quote = "\'";

    public Set<String> diffs = new HashSet<>();
    public Set<String> diffsFunc = new HashSet<>();
    Set<T> hc;

    public Set<T> getHc() {
        return hc;
    }

    public CompareLists(List<T> a, List<T> b) {
        Set<T> ha = new HashSet(a);
        Set<T> hb = new HashSet(b);

        hc = new HashSet(ha);

        hc.removeAll(hb);

        Iterator it = hc.iterator();

        while (it.hasNext()) {
            diffs.add(it.next().toString());

        }

        diffsFunc = diffs;

    }

    public String getDiffs2String(String seperator) {

        Set diffsQuoted = new HashSet<>();

        for (String d : diffs) {
            diffsQuoted.add(quote + d + quote);
        }

        return StringUtils.join(diffsQuoted, seperator);

    }

    public Set<String> getDiffs() {
        return diffs;
    }

    public void setDiffs(Set<String> diffs) {
        this.diffs.addAll(diffs);
    }

    public void setDiffs(CompareLists other) {
        this.diffs.addAll(other.diffs);
    }

    public Set<String> getDiffsFunc() {
        return diffsFunc;
    }

}
