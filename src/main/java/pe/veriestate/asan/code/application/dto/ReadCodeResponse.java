package pe.marker.asan.code.application.dto;

import java.util.List;

public class ReadCodeResponse {
    static public class ReadCodeGroup {
        public Long id;
        public String displayId;
        public String name;
        public String description;
    }
    static public class ReadCode {
        public Long id;
        public String displayId;
        public String name;
        public String description;
    }
    
    public ReadCodeGroup codeGroup;
    public List<ReadCode> codeList;
}
