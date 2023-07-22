import React from 'react'
import { DownOutlined } from '@ant-design/icons';
import { Dropdown, Space, Divider, Button, theme, Avatar } from 'antd';
import { Link } from 'react-router-dom';
const { useToken } = theme;
const items = [
  {
    key: '1',
    label: (
      <Link to="/profile">
        Profile
      </Link>
    ),
  },
  {
    key: '3',
    label: (
        <Link to="/login">
        Logout
       </Link>
    ),
  },
];

function ProfileButton(props) {
      const menuStyle = {
        boxShadow: 'none',
        backgroundColor: "white"
      };
  return (
    <Dropdown
    menu={{
      items,
    }}
    dropdownRender={(menu) => (
      <div>
        {React.cloneElement(menu, {
          style: menuStyle,
        })}
        <Divider
          style={{
            margin: 0,
          }}
        />
      </div>
    )}
  >
    <a onClick={(e) => e.preventDefault()}>
      <Space>
        {props.firstName}, {props.lastName}
        <Avatar size="small">{props.firstName.charAt(0)}{props.lastName.charAt(0)}</Avatar>
      </Space>
    </a>
  </Dropdown>
)
}

export default ProfileButton
