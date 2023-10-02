package pe.marker.asan.code.application.dto;

import java.util.List;

public class CreateCodeRequest {
    static public class CreateCodeGroup {
        public String displayId;
        public String name;
        public String description;
    }
    static public class CreateCode {
        public String displayId;
        public String name;
        public String description;
    }

    public CreateCodeGroup codeGroup;
    public List<CreateCode> codeList;
}
