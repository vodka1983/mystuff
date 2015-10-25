package func_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
presidentpage_list_pie_test.class,
pres_search_by_year.class,
pres_search_last_and_first.class,
pres_search_first_only.class,
pres_search_last_only.class
})

public class runMe  {

}
