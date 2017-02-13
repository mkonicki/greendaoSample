package konicki.mateusz.greendaosample;

import android.content.Context;
import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import konicki.mateusz.greendaosample.db.repository.ToDoRepository;
import konicki.mateusz.greendaosample.entites.ToDo;
import konicki.mateusz.greendaosample.entites.ToDoType;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Mateusz on 13.02.2017.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", sdk = Build.VERSION_CODES.LOLLIPOP)
public class ToDoRepositoryTest {
    @Test
    public void checkQueryBasedOnType() {
        ////GIVEN
        Context context = Robolectric.setupActivity(TestActivity.class);

        ToDoRepository repository = new ToDoRepository(context);
        ToDo watchMovie = new ToDo("Watch Movie", ToDoType.HOBBY);
        ToDo cookDinner = new ToDo("Cook dinner", ToDoType.DOMESTICITY);
        ToDo makeLaundry = new ToDo("Make Laundry", ToDoType.DOMESTICITY);
        ToDo writeEmails = new ToDo("Write emails", ToDoType.WORK);
        ////WHEN
        repository.create(Arrays.asList(watchMovie, cookDinner, makeLaundry, writeEmails));

        ////THEN
        List<ToDo> toDoWithDomesticityType = repository.getToDoWithType(ToDoType.DOMESTICITY);

        assertThat(toDoWithDomesticityType).size().isEqualTo(2);
        assertThat(toDoWithDomesticityType).containsOnlyOnce(cookDinner, makeLaundry);

    }

    @Test
    public void checkUniqueTaskDescription() {
        ////GIVEN
        Context context = Robolectric.setupActivity(TestActivity.class);

        ToDoRepository repository = new ToDoRepository(context);
        ToDo watchMovie = new ToDo("Watch Movie", ToDoType.HOBBY);
        ////WHEN
        try {
            repository.create(Arrays.asList(watchMovie, watchMovie));
        } catch (RuntimeException e) {
            ////THEN
            assertThat(e).isNotNull();
        }

    }


}
