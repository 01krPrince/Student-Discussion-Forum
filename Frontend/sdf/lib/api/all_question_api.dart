import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:sdf/api/response/question.dart';

class AllQuestionApi {
  static const String _url = 'http://localhost:8080/sdf/question/viewAllQuestions';

  Future<List<Question>> fetchQuestions() async {
    final response = await http.get(Uri.parse(_url));

    if (response.statusCode == 200) {
      List<dynamic> data = json.decode(response.body);
      return data.map((json) => Question.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load questions');
    }
  }
}
