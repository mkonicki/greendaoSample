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
public class BaseRepositoryTest {

    @Test
    public void checkInsertToDatabase() {
        ////GIVEN
        Context context = Robolectric.setupActivity(TestActivity.class);

        ToDoRepository repository = new ToDoRepository(context);
        ToDo toDo = new ToDo("Watch Movie", ToDoType.HOBBY);
        ////WHEN
        Long id = repository.create(toDo);

        ////THEN
        List<ToDo> toDoList = repository.read();

        assertThat(toDoList).size().isEqualTo(1);
        assertThat(toDoList).containsOnly(toDo);
        assertThat(toDoList.get(0).getId()).isEqualTo(id);

    }

    @Test
    public void checkInsertManyEntitiesToDatabase() {
        ////GIVEN
        Context context = Robolectric.setupActivity(TestActivity.class);

        ToDoRepository repository = new ToDoRepository(context);
        ToDo toDo = new ToDo("Watch Movie", ToDoType.HOBBY);
        ToDo makeLaundry = new ToDo("Make Laundry", ToDoType.DOMESTICITY);
        ToDo writeEmails = new ToDo("Write emails", ToDoType.WORK);
        ////WHEN
        repository.create(Arrays.asList(toDo, makeLaundry, writeEmails));

        ////THEN
        List<ToDo> toDoList = repository.read();

        assertThat(toDoList).size().isEqualTo(3);
        assertThat(toDoList).containsOnlyOnce(toDo, makeLaundry, writeEmails);
    }


    @Test
    public void checkInsertOrUpdateToDatabase() {
        ////GIVEN
        Context context = Robolectric.setupActivity(TestActivity.class);

        String toDoDescription = "Watch Movie";
        String toDoDescriptionUpdate = "Updated watch movie";
        ToDoRepository repository = new ToDoRepository(context);
        ToDo toDo = new ToDo(toDoDescription, ToDoType.HOBBY);

        ////WHEN
        Long id = repository.create(toDo);
        toDo.setToDo(toDoDescriptionUpdate);
        Long updatedId = repository.createOrUpdate(toDo);

        ////THEN
        List<ToDo> toDoList = repository.read();

        assertThat(toDoList).size().isEqualTo(1);
        assertThat(updatedId).isEqualTo(id);
        assertThat(toDoList).containsOnly(toDo);
    }

    @Test
    public void checkUpdateToDatabase() {
        ////GIVEN
        Context context = Robolectric.setupActivity(TestActivity.class);

        String toDoDescription = "Watch Movie";
        String toDoDescriptionUpdate = "Updated watch movie";
        ToDoRepository repository = new ToDoRepository(context);
        ToDo toDo = new ToDo(toDoDescription, ToDoType.HOBBY);

        ////WHEN
        Long id = repository.create(toDo);
        toDo.setToDo(toDoDescriptionUpdate);
        repository.update(toDo);

        ////THEN
        List<ToDo> toDoList = repository.read();

        assertThat(toDoList).size().isEqualTo(1);
        assertThat(toDoList.get(0).getId()).isEqualTo(id);
        assertThat(toDoList).containsOnly(toDo);
    }

    @Test
    public void checkDeleteInDatabase() {
        ////GIVEN
        Context context = Robolectric.setupActivity(TestActivity.class);

        String toDoDescription = "Watch Movie";

        ToDoRepository repository = new ToDoRepository(context);
        ToDo toDo = new ToDo(toDoDescription, ToDoType.HOBBY);

        ////WHEN
        Long id = repository.create(toDo);
        repository.deleteById(id);

        ////THEN
        List<ToDo> toDoList = repository.read();

        assertThat(toDoList).isEmpty();

    }
}
