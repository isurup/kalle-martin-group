package turtlekit2.kernel.tools;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class SimuFilter extends FileFilter {
    public final static String xml = "xml";
    public final static String smu = "smu";
    public final static String tk2 = "tk2";
    
    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String extension = getExtension(f);
        if (extension != null) {
            if (extension.equals(xml) ||
                    extension.equals(smu) ||
                    extension.equals(tk2)) {
                return true;
            } else {
                return false;
            }
        }
        
        return false;
    }
    
    public String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    //The description of this filter
    public String getDescription() {
        return "Turtlekit2 simulation files";
    }
}