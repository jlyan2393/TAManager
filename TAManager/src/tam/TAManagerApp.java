package tam;

import java.util.Locale;
import tam.data.TAData;
import tam.file.TAFiles;
import tam.workspace.TAWorkspace;
import djf.AppTemplate;
import tam.style.TAStyle;
import static javafx.application.Application.launch;
import tam.data.CourseData;
import tam.data.RecitationsData;
import tam.data.ScheduleData;
import tam.data.StudentsData;
import tam.data.TeamsData;

/**
 * This class serves as the application class for our TA Manager App program. 
 * Note that much of its behavior is inherited from AppTemplate, as defined in
 * the Desktop Java Framework. This app starts by loading all the UI-specific
 * settings like icon files and tooltips and other things, then the full 
 * User Interface is loaded using those settings. Note that this is a 
 * JavaFX application.
 * 
 * @author Richard McKenna
 * @version 1.0
 */
public class TAManagerApp extends AppTemplate {
    /**
     * This hook method must initialize all four components in the
     * proper order ensuring proper dependencies are respected, meaning
     * all proper objects are already constructed when they are needed
     * for use, since some may need others for initialization.
     */
    @Override
    public void buildAppComponentsHook() {
        // CONSTRUCT ALL FOUR COMPONENTS. NOTE THAT FOR THIS APP
        // THE WORKSPACE NEEDS THE DATA COMPONENT TO EXIST ALREADY
        // WHEN IT IS CONSTRUCTED, SO BE CAREFUL OF THE ORDER
        dataComponent = new TAData(this);
        courseDataComponent = new CourseData(this);
        recitationDataComponent = new RecitationsData(this);
        scheduleDataComponent = new ScheduleData(this);
        teamDataComponent = new TeamsData(this);
        studentDataComponent = new StudentsData(this);
        workspaceComponent = new TAWorkspace(this);
        fileComponent = new TAFiles(this);
        styleComponent = new TAStyle(this);
    }
    
    /**
     * This is where program execution begins. Since this is a JavaFX app it
     * will simply call launch, which gets JavaFX rolling, resulting in sending
     * the properly initialized Stage (i.e. window) to the start method inherited
     * from AppTemplate, defined in the Desktop Java Framework.
     */
    public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	launch(args);
    }
}