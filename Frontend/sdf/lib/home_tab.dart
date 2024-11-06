import 'package:flutter/material.dart';
import 'package:sdf/tab_pages/AboutUsTabContent.dart';
import 'package:sdf/tab_pages/HomeTabContent.dart';
import 'package:sdf/tab_pages/MyAnswerTabContent.dart';
import 'package:sdf/tab_pages/MyQuestionsTabContent.dart';
import 'package:sdf/tab_pages/NotificationTabContent.dart';

class HomeTab extends StatefulWidget {
  const HomeTab({super.key});

  @override
  _HomeTabState createState() => _HomeTabState();
}

class _HomeTabState extends State<HomeTab> with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: 5, vsync: this);
  }

  @override
  void dispose() {
    _tabController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          '∂ιѕ¢υѕѕιση ƒσřυɱ',
          style: TextStyle(
            fontWeight: FontWeight.bold, // or any other desired font weight
          ),
        ),
        bottom: TabBar(
          controller: _tabController,
          isScrollable: true,
          tabs: const [
            Tab(child: Padding(padding: EdgeInsets.only(right: 10 , top: 10 , bottom: 10), child: Icon(Icons.home))),
            Tab(child: Padding(padding: EdgeInsets.all(10.0), child: Icon(Icons.question_answer))),
            Tab(child: Padding(padding: EdgeInsets.all(10.0), child: Icon(Icons.comment))),
            Tab(child: Padding(padding: EdgeInsets.all(10.0), child: Icon(Icons.notifications))),
            Tab(child: Padding(padding: EdgeInsets.all(10.0), child: Icon(Icons.info))),
            Tab(child: Padding(padding: EdgeInsets.all(10.0), child: Icon(Icons.article))),
          ],
        ),
      ),
      body: TabBarView(
        controller: _tabController,
        children: const [
          HomeTabContent(),
          MyQuestionsTabContent(),
          MyAnswerTabContent(),
          NotificationTabContent(),
          AboutUsTabContent(),
        ],
      ),
    );
  }
}
