import 'package:flutter/material.dart';
import 'QuestionPage.dart';

class AboutUs extends StatelessWidget {
  const AboutUs({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Center(
          child: Text(
            "Profile",
            style: TextStyle(
              color: Colors.white70,
              fontSize: 24,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
        backgroundColor: Colors.deepPurple,
        iconTheme: const IconThemeData(
          color: Colors.white70,
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(horizontal: 16.0, vertical: 20.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            _buildActionButton(
              context,
              title: 'View My Questions',
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => QuestionPage(),
                  ),
                );
              },
            ),
            const SizedBox(height: 16),
            _buildActionButton(
              context,
              title: 'View All Upvotes',
              onPressed: () {},
            ),
            const SizedBox(height: 16),
            _buildActionButton(
              context,
              title: 'View All Upvotes',
              onPressed: () {},
            ),
            const SizedBox(height: 16),
            // Divider
            const Divider(
              color: Colors.grey,
              thickness: 1,
            ),
            const SizedBox(height: 16),
            _buildFooter(),
          ],
        ),
      ),
    );
  }

  Widget _buildActionButton(BuildContext context, {
    required String title,
    required VoidCallback onPressed,
  }) {
    return Container(
      width: double.infinity,
      child: ElevatedButton(
        onPressed: onPressed,
        child: Text(
          title,
          style: TextStyle(
            fontSize: 16,
            fontWeight: FontWeight.bold,
          ),
        ),
        style: ElevatedButton.styleFrom(
          foregroundColor: Colors.white,
          backgroundColor: Colors.deepPurple,
          padding: EdgeInsets.symmetric(vertical: 14),
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(8),
          ),
        ),
      ),
    );
  }

  Widget _buildFooter() {
    return Center(
      child: Text(
        '© 2024 Flutter App. All rights reserved.',
        style: TextStyle(
          color: Colors.grey[600],
          fontSize: 14,
        ),
      ),
    );
  }
}
