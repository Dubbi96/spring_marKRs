package pe.veriestate.asan.common.status;

import lombok.Data;

@Data
public class HttpMessage {
    private HttpStatusEnum status;
    private String message;
    private Object data;

    public HttpMessage() {
        this.status = HttpStatusEnum.BAD_REQUEST;
        this.message = null;
        this.data = null;
    }
}
