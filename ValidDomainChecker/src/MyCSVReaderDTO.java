
public class MyCSVReaderDTO {

    private Integer userId;
    private String aminities;
    private Long timestamp;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAminities() {
        return aminities;
    }

    public void setAminities(String aminities) {
        this.aminities = aminities;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MyCSVReaderDTO [userId=" + userId + ", aminities=" + aminities + ", timestamp=" + timestamp + "]";
    }

}
