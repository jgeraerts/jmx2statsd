package net.umask.jmx2statsd.filters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.umask.jmx2statsd.ObjectNameFilter;

/**
 * User: JoGeraerts
 * Date: 1/07/13
 * Time: 21:46
 */
public class ActiveMQFilter extends DelegatingFilter {
    private static List<ObjectNameFilter> FILTERS = new ArrayList<ObjectNameFilter>();
    static {
        Set<String> values = new HashSet<String>();
        values.add("Topic");
        values.add("Queue");
        FILTERS.add(new SimpleDomainFilter("org.apache.activemq"));
        FILTERS.add(new KeyPropertyValuesFilter("Type",values));
    }

    public ActiveMQFilter(){
        super(new AndFilter(FILTERS));
    }
}
