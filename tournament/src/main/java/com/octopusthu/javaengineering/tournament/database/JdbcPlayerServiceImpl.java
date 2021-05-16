package com.octopusthu.javaengineering.tournament.database;

import com.octopusthu.javaengineering.tournament.common.exception.DomainObjectException;
import com.octopusthu.javaengineering.tournament.core.Player;
import com.octopusthu.javaengineering.tournament.core.PlayerService;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用 JDBC 操作关系型数据库实现 {@link PlayerService}
 *
 * @author octopusthu@gmail.com
 */
@Service
public class JdbcPlayerServiceImpl implements PlayerService {
    private final String dataSourceUrl = "jdbc:mysql://localhost:3306/tournament";
    private final String dataSourceUsername = "tournament";
    private final String dataSourcePassword = "tournament";

    @Override
    public void createPlayer(Integer id, String name) throws DomainObjectException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {

            // 实例化 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            // 连接数据库
            conn = DriverManager.getConnection(dataSourceUrl, dataSourceUsername, dataSourcePassword);

            // 查询语句
            String query = "insert into player(seq,name) values (?,?)";

            // 创建 PreparedStatement 对象
            preparedStatement = conn.prepareStatement(query);

            // 绑定参数
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);

            // 执行查询
            preparedStatement.executeUpdate();

            // 确认已成功插入一条数据
            int updateCount = preparedStatement.getUpdateCount();
            if (updateCount != 1) {
                throw new DomainObjectException("Unexpected error occurred! updateCount is: " + updateCount);
            }

        } catch (DomainObjectException e) {
            throw e;
        } catch (Exception e) {
            throw new DomainObjectException(e);
        } finally {
            // 安全关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    @Override
    public void removePlayer(Integer id) throws DomainObjectException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {

            // 实例化 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            // 连接数据库
            conn = DriverManager.getConnection(dataSourceUrl, dataSourceUsername, dataSourcePassword);

            // 查询语句
            String query = "delete from player where seq=?";

            // 创建 PreparedStatement 对象
            preparedStatement = conn.prepareStatement(query);

            // 绑定参数
            preparedStatement.setInt(1, id);

            // 执行查询
            preparedStatement.executeUpdate();

            // 确认已成功删除一条数据
            int updateCount = preparedStatement.getUpdateCount();
            if (updateCount == 0) {
                throw new DomainObjectException("Nonexistent player id: " + id);
            } else if (updateCount != 1) {
                throw new DomainObjectException("Unexpected error occurred! updateCount is: " + updateCount);
            }

        } catch (DomainObjectException e) {
            throw e;
        } catch (Exception e) {
            throw new DomainObjectException(e);
        } finally {
            // 安全关闭资源
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    @Override
    public Player getPlayer(Integer id) throws DomainObjectException {
        Player player;

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            // 实例化 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            // 连接数据库
            conn = DriverManager.getConnection(dataSourceUrl, dataSourceUsername, dataSourcePassword);

            // 查询语句
            String query = "select seq,name from player where seq=?";

            // 创建 PreparedStatement 对象
            preparedStatement = conn.prepareStatement(query);

            // 绑定参数
            preparedStatement.setInt(1, id);

            // 执行查询
            rs = preparedStatement.executeQuery();

            // 获取第一条查询结果
            if (rs.next()) {
                Integer playerId = rs.getInt("seq");
                String playerName = rs.getString("name");
                player = new Player(playerId, playerName);
            } else {
                throw new DomainObjectException("Nonexistent player id: " + id);
            }

            // 如果查询结果不唯一，则报异常
            if (rs.next()) {
                throw new DomainObjectException("Multiple players exist for id: " + id);
            }

        } catch (DomainObjectException e) {
            throw e;
        } catch (Exception e) {
            throw new DomainObjectException(e);
        } finally {
            // 安全关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        return player;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {

            // 实例化 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

            // 连接数据库
            conn = DriverManager.getConnection(dataSourceUrl, dataSourceUsername, dataSourcePassword);

            // 查询语句
            String query = "select seq,name from player";

            // 创建 PreparedStatement 对象
            preparedStatement = conn.prepareStatement(query);

            // 执行查询
            rs = preparedStatement.executeQuery();

            // 获取全部查询结果
            while (rs.next()) {
                players.add(
                    new Player(
                        rs.getInt("seq"),
                        rs.getString("name")
                    )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 安全关闭资源
            try {
                if (rs != null) {
                    rs.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        return players;
    }
}
