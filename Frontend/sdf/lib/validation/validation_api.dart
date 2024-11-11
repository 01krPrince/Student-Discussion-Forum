import 'dart:convert';
import 'package:http/http.dart' as http;

final String ngRokUrl = "https://9fe2-2409-40e4-3e-a0ad-6417-27d1-c41c-2f0.ngrok-free.app/";

class AuthService {
  final String _signUpUrl = "${ngRokUrl}sdf/user/signUpUrl";
  final String _signInUrl = "${ngRokUrl}sdf/user/login";

  static String? finalUserId;
  static String? finalUserName;

  Future<http.Response> signUp(String username, String phone, String password) async {
    try {
      final response = await http.post(
        Uri.parse(_signUpUrl),
        headers: {'Content-Type': 'application/json'},
        body: jsonEncode({
          'username': username,
          'phone': phone,
          'password': password,
        }),
      );
      return response;
    } catch (e) {
      throw Exception('Failed to sign up: $e');
    }
  }

  Future<http.Response> signIn(String phoneNumber, String password) async {
    final url = Uri.parse("$_signInUrl?phoneNumber=$phoneNumber&password=$password");

    try {
      print("Attempting to sign in with phone: $phoneNumber and password: $password");

      final response = await http.post(
        url,
        headers: {'Content-Type': 'application/json'},
      );

      if (response.statusCode == 200) {
        var responseData = jsonDecode(response.body);

        finalUserId = responseData['userId'];
        finalUserName = responseData['userName'];
        print("Login successful, userId: $finalUserId");

        return response;
      } else {
        throw Exception('Failed to sign in: ${response.body}');
      }
    } catch (e) {
      print("Exception occurred: $e");
      throw Exception('Failed to sign in: $e');
    }
  }
}
