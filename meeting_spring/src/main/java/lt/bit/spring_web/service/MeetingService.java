package lt.bit.spring_web.service;

import lt.bit.spring_web.data.Meeting;
import lt.bit.spring_web.data.Person;
import lt.bit.spring_web.db.Db;
import lt.bit.spring_web.exceptions.ApiException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Service
//@AllArgsConstructor
@Repository
public class MeetingService {

    private final Db db;

    public MeetingService(Db db) {
        this.db = db;
    }

    public List<Meeting> getAllMeetings() {
        return db.readJsonFile();
    }

    public Meeting addNewMeeting(Meeting meeting) {
        List<Meeting> meetings = getAllMeetings();
        meetings.add(meeting);
        db.writeToJsonFile(meetings);
        return meeting;
    }

    public List<Meeting> getMeetingByDescription(List<Meeting> list, String description) {
        List<Meeting> sortas = new ArrayList<>();
        for (Meeting meetas : list) {
            if (meetas.getDescription().toLowerCase().contains(description.toLowerCase())) {
                sortas.add(meetas);
            }
        }
        return sortas;
    }

    public List<Meeting> getMeetingsByResponsiblePerson(List<Meeting> list, Integer id) {
        List<Meeting> sortas = new ArrayList<>();
        for (Meeting meetas : list) {
            if (meetas.getResponsiblePerson().getId().equals(id)) {
                sortas.add(meetas);
            }
        }
        return sortas;
    }

    public List<Meeting> getMeetingsByCategory(List<Meeting> list, String category) {
        List<Meeting> sortas = new ArrayList<>();
        for (Meeting meetas : list) {
            if (meetas.getCategory().toLowerCase().contains(category.toLowerCase())) {
                sortas.add(meetas);
            }
        }
        return sortas;
    }

    public List<Meeting> getMeetingsByType(List<Meeting> list, String type) {
        List<Meeting> sortas = new ArrayList<>();
        for (Meeting meetas : list) {
            if (meetas.getType().toLowerCase().contains(type.toLowerCase())) {
                sortas.add(meetas);
            }
        }
        return sortas;
    }

//    public List<Meeting> getMeetingsByDateFrom(List<Meeting> list, String dateFrom) {
//        List<Meeting> sortas = new ArrayList<>();
//        LocalDateTime dateFromDt = LocalDateTime.parse(dateFrom);
//        for (Meeting meetas : list) {
//            if (meetas.getEndDate().compareTo(dateFromDt) >= 0) {
//                sortas.add(meetas);
//            }
//        }
//        return sortas;
//    }
//
//    public List<Meeting> getMeetingsByDateTo(List<Meeting> list, String dateTo) {
//        List<Meeting> sortas = new ArrayList<>();
//        LocalDateTime dateToDt = LocalDateTime.parse(dateTo);
//        for (Meeting meetas : list) {
//            if (meetas.getEndDate().compareTo(dateToDt) >= 0) {
//                sortas.add(meetas);
//            }
//        }
//        return sortas;
//    }

    public List<Meeting> getMeetingsByNumberOfAttendeesFrom(List<Meeting> list, Integer nr) {
        List<Meeting> sortas = new ArrayList<>();
        for (Meeting meetas : list) {
            if (meetas.getAtendees().size() >= nr) {
                sortas.add(meetas);
            }
        }
        return sortas;
    }

    public List<Meeting> getMeetingsByNumberOfAttendeesTo(List<Meeting> list, Integer nr) {
        List<Meeting> sortas = new ArrayList<>();
        for (Meeting meetas : list) {
            if (meetas.getAtendees().size() <= nr) {
                sortas.add(meetas);
            }
        }
        return sortas;
    }

    public Meeting getOneMeeting(List<Meeting> list, Integer id) {
        if (id == null) {
            throw new NullPointerException("You have to get id for meeting");
        }
        for (Meeting meeting : list) {
            if (id.equals(meeting.getId())) {
                System.out.println("Meeting we are looking for: " + meeting);
                return meeting;
            }
        }
        throw new IllegalArgumentException("Meeting not found");
    }

    public void addAttendee(Person attendee,
                            Integer meetingId) {
        List<Meeting> meetings = getAllMeetings();
        for (Meeting meeting : meetings) {
            if (meetingId.equals(meeting.getId())) {
                List<Integer> attendees = meeting.getAtendees();
                attendees.add(attendee.getId());
                meeting.setAtendees(attendees);
                break;
            }
        }
        db.writeToJsonFile(meetings);
    }

    public List<Meeting> deleteMeeting(Integer id) {
        List<Meeting> meetings = getAllMeetings();
        for (Meeting meeting : meetings) {
            if (id.equals(meeting.getId())) {
                meetings.remove(meeting);
                db.writeToJsonFile(meetings);
                break;
            } else {
                throw new ApiException(
                        "Cannot delete meeting because you are not" +
                                "this meeting's responsible person", 4024);
            }
        }
        return meetings;
    }

    public List<Meeting> updateMeeting(Meeting setMeeting) {
        List<Meeting> meetings = getAllMeetings();
        for (Meeting meeting : meetings) {
            if (setMeeting.getId().equals(meeting.getId())) {
                meeting.setName(setMeeting.getName());
                meeting.setResponsiblePerson(setMeeting.getResponsiblePerson());
                meeting.setCategory(setMeeting.getCategory());
                meeting.setDescription(setMeeting.getDescription());
                meeting.setType(setMeeting.getType());
                meeting.setStartDate(setMeeting.getStartDate());
                meeting.setEndDate(setMeeting.getEndDate());
                meeting.setAtendees(setMeeting.getAtendees());
                meetings.set(meeting.getId(), meeting);
                db.writeToJsonFile(meetings);
            }
        }
        return meetings;
    }
}
