package pe.veriestate.asan.code.application.dto;

import java.util.List;

public class UpdateCodeRequest {
    static public class UpdateCodeGroup {
        public String name;
        public String description;
    }
    static public class UpdateCode {
        public String displayId;
        public String name;
        public String description;
    }

    public UpdateCodeGroup codeGroup;
    public List<UpdateCode> codeList;
}
