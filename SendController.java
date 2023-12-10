package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SendController {

    @FXML
    private ListView<HBox> messageListView;
    @FXML
    private TextField inputTextField;

    private final ObservableList<HBox> messages = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        messageListView.setItems(messages);
    }

    @FXML
    private void handleSendButton(ActionEvent event) {
        String message = inputTextField.getText();
        if (!message.isEmpty()) {
            // Tạo một HBox để chứa đoạn tin nhắn
            HBox messageBox = createMessageBox(message);

            // Thêm HBox vào danh sách tin nhắn
            messages.add(messageBox);

            // Xóa nội dung trong ô nhập liệu
            inputTextField.clear();
        }
    }

    private HBox createMessageBox(String message) {
        // Tạo một HBox chứa đoạn tin nhắn
        HBox messageBox = new HBox();
        Button button = new Button(message);
        messageBox.getChildren().add(button);

        // Đặt căn chỉnh của HBox là bên phải
        messageBox.setAlignment(Pos.CENTER_RIGHT);

        return messageBox;
    }
}
