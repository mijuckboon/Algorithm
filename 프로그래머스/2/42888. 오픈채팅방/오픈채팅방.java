import java.util.*;

class Solution {
    static StringTokenizer st;
    static Map<String, String> users;
    static List<String> messages;
        
    // static Map<String, String> inOut; // command, id 순서쌍이 아니니까 클래스 만들어야 할 듯.
    
    static class Command {
        private String operation;
        private String user;
        private String nickname;
        
        public Command(String string) {
            st = new StringTokenizer(string);
            this.operation = st.nextToken();
            this.user = st.nextToken();
            if (st.hasMoreTokens()) {
                this.nickname = st.nextToken();
            }
        }
        
        private void execute() {
            switch (this.operation) {
                    case "Enter" -> { messages.add("%s님이 들어왔습니다.");
                                    users.put(this.user, this.nickname); }
                    case "Leave" -> { messages.add("%s님이 나갔습니다."); }
                    case "Change" -> { users.put(this.user, this.nickname); }
            }
        }
    
        
    }
    
     private String insert(String message, Command command) {
            return String.format(message, command.nickname);
        }

    public String[] solution(String[] record) {
        Command[] commands = new Command[record.length];
        users = new HashMap<>();
        messages = new ArrayList<>();
        
        for (int i = 0; i < record.length; i++) {
            commands[i] = new Command(record[i]);
            commands[i].execute();
        }
        
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            Command command = commands[i];
            if (!command.operation.equals("Change")) {
                messages.set(idx, String.format(messages.get(idx), users.get(command.user)));
                // messages.set(idx, String.format(messages.get(idx), command.nickname));
                idx += 1;
            }
        }
        
    return messages.toArray(new String[0]);
    }
}