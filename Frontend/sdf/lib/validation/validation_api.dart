import 'dart:convert';
import 'package:http/http.dart' as http;

class AuthService {
  final String _signUpUrl = 'http://localhost:8080/sdf/user/signUp';
  final String _signInUrl = 'http://localhost:8080/sdf/user/login';

  // Signup function
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

  // Sign in function
  Future<http.Response> signIn(String phoneNumber, String password) async {
    final url = Uri.parse("$_signInUrl?phoneNumber=$phoneNumber&password=$password");

    try {
      print("Attempting to sign in with phone: $phoneNumber and password: $password");

      final response = await http.post(
        url,
        headers: {'Content-Type': 'application/json'},
      );

      print("Response status: ${response.statusCode}");
      print("Response body: ${response.body}");

      if (response.statusCode == 200) {
        // Success, return response
        return response;
      } else {
        // Display server response for better diagnosis
        throw Exception('Failed to sign in: ${response.body}');
      }
    } catch (e) {
      print("Exception occurred: $e");
      throw Exception('Failed to sign in: $e');
    }
  }


}